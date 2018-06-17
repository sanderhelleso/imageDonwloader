package com.sanderhelleso.imageDownloader;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class UrlDownloader {

    public static String download(String sourceURL, String targetDirectory, boolean imgDownload) throws IOException {
        Path targetPath = null;
        URL url = new URL(sourceURL);
        String originalFile = sourceURL.substring(sourceURL.lastIndexOf('/') + 1, sourceURL.length());
        String[] fileArr = null;
        String fileName = null;

        if (imgDownload) {
            fileArr = originalFile.split(("_"));
            fileName = fileArr[0].split("-")[1] + "_" + fileArr[1];
        }

        else {
            fileArr = originalFile.split((":"));
            fileName = fileArr[1];
        }

        File f = new File("/Users/sande/Documents/GitHub/InfoSys---Projects/Java/imageDonwloader/logos/" + fileName.toLowerCase());
        if(!f.exists()){
            System.out.println("success");
            System.out.println(fileName);
            targetPath = new File(targetDirectory + File.separator + fileName.toLowerCase()).toPath();
            Files.copy(url.openStream(), targetPath, StandardCopyOption.REPLACE_EXISTING);
        }
        return null;
    }
}
