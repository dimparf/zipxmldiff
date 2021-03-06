package ru.nyxale.zipdiff;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipFile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;


@Configuration
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@SpringBootApplication
@EnableScheduling
@ComponentScan
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        try {
            Diff diff = new Diff();
            String oldFileName = "oldFile.zip";
            String newFileName = "newFile.zip";
            List<FileFromZip> oldFiles = ZipProcessor.getFilesMetadata(new ZipFile(oldFileName));
            List<FileFromZip> newFiles = ZipProcessor.getFilesMetadata(new ZipFile(newFileName));
            //Uncomment this code for creating test xml files
            //ZipProcessor.unzip(oldFileName);
            //ZipProcessor.unzip(newFileName);

            diff.oldFileName = oldFileName;
            diff.newFileName = newFileName;

            diff.oldFileEntitiesCount = oldFiles.size();
            diff.newFileEntitiesCount = newFiles.size();

            int max = Math.max(diff.oldFileEntitiesCount, diff.newFileEntitiesCount);
            if (max == diff.oldFileEntitiesCount) {
                diff.deletedFilesCount = diff.oldFileEntitiesCount - diff.newFileEntitiesCount;
            } else {
                diff.newFileEntitiesCount = diff.newFileEntitiesCount - diff.oldFileEntitiesCount;
            }

            //compare by CRC
            newFiles.removeAll(oldFiles);
            diff.modifiedFilesCont = newFiles.size();
            System.out.println("Modified files: " + newFiles);
            XmlUnitDiffer xmlUnitDiffer = new XmlUnitDiffer();
            diff.nodeBodies = xmlUnitDiffer.processDiffFiles(newFiles, oldFiles).orElse(Collections.emptyList());
            diff.modifiedFilesCont = diff.nodeBodies.size();
            System.out.println(diff);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

}

