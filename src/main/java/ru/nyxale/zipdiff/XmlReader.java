package ru.nyxale.zipdiff;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

class XmlReader {

    String readXmlFile(FileFromZip file) throws IOException {
        FileReader fileReader = new FileReader(new File(file.zipFileName.substring(0, file.zipFileName.indexOf(".")) + "/" + file.fileName));
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        StringBuilder out = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            out.append(line);
        }
        fileReader.close();
        bufferedReader.close();
        return out.toString();
    }

}
