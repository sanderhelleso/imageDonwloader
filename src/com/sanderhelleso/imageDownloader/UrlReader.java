package com.sanderhelleso.imageDownloader;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class UrlReader {

    public static ArrayList<String> readStringFromURL(String requestURL) throws IOException {
        URL wiki = new URL("https://no.wikipedia.org/wiki/Norges_kommuner");
        BufferedReader in = new BufferedReader(new InputStreamReader(wiki.openStream()));

        String inputLine;
        ArrayList<String> lines = new ArrayList<>();
        while ((inputLine = in.readLine()) != null)
            if (inputLine.contains("<td><a")) {
                lines.add(inputLine);
            }
        in.close();
        return lines;
    }

    // remove brakcets for a pure URL
    public static String stringSplitter(String fileName) {
        String[] removeBrackets = fileName.split("");
        StringBuilder sb = new StringBuilder("");
        for (int x = 1; x < removeBrackets.length - 2; x++) {
            sb.append(removeBrackets[x]);
        }
        return sb.toString();
    }

    public static String getUrlSrc(String domain, ArrayList<String> data) throws IOException {
        String imgUrl = "";
        for (int i = 0; i < data.size(); i++) {
            String[] link = data.get(i).split("<img");
            imgUrl = link[0].split("href=")[1].split("class")[0];
            String ext = imgUrl.substring(imgUrl.length() - 5);
            ext = ext.substring(0, ext.length() - 2);

            // get img url
            if (ext.equals("svg")) {
                String url = domain + UrlReader.stringSplitter(imgUrl);
                System.out.println(url);
                //System.out.println(url);
                ArrayList<String> fileData = UrlReader.readStringFromURL(url);
                for (int x = 0; x < fileData.size(); x++) {
                    String[] imgSrcs = fileData.get(i).split("//");
                    String srcUrl = imgSrcs[1];
                    srcUrl = srcUrl.split(" ")[0];
                    srcUrl = srcUrl.substring(0, srcUrl.length() - 1);
                    UrlDownloader.download("https://" + srcUrl, "./logos", true);
                }
            }
        }
        return imgUrl;
    }
}
