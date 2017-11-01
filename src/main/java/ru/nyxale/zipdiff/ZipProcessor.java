package ru.nyxale.zipdiff;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/**
 * 0. Compare count of files in two archives
 * 1. Get files from zip
 * 2. Diff files
 * 2a. Compare CRC for files.
 * 2b. Compare body of files.
 * 3. Write diff to json
 */
class ZipProcessor {
    /**
     * 1. Get files data from zip
     *
     * @param zip zip file name
     * @return list of FileFromZip
     * @throws IOException
     */
    public static List<FileFromZip> getFilesMetadata(ZipFile zip) throws IOException {
        List<FileFromZip> files = new ArrayList<>();
        for (Enumeration e = zip.entries(); e.hasMoreElements(); ) {
            ZipEntry entry = (ZipEntry) e.nextElement();
            if (!entry.isDirectory()) {
                files.add(new FileFromZip(zip.getName(), entry.getName(), entry.getSize(), null, entry.getCrc()));
            }
        }
        return files;
    }

    public static void unzip(String zipFileName) throws IOException {
        byte[] buffer = new byte[1024];
        ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFileName));
        ZipEntry zipEntry = zis.getNextEntry();
        while (zipEntry != null) {
            String fileName = zipEntry.getName();
            System.out.println("Extract " + fileName);
            File unzippedFilesDir = new File(zipFileName.substring(0, zipFileName.indexOf(".")));
            unzippedFilesDir.mkdir();
            File newFile = new File(zipFileName.substring(0, zipFileName.indexOf(".")) + "/" + fileName);
            FileOutputStream fos = new FileOutputStream(newFile);
            int len;
            while ((len = zis.read(buffer)) > 0) {
                fos.write(buffer, 0, len);
            }
            fos.close();
            zipEntry = zis.getNextEntry();
        }
        zis.closeEntry();
        zis.close();
    }

}

