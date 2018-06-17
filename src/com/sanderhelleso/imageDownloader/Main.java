package com.sanderhelleso.imageDownloader;

import java.io.IOException;
import java.util.ArrayList;

public class Main extends UrlReader {

    public static void main(String[] args) throws IOException {
	    // array with lines from url
        ArrayList<String > data = UrlReader.readStringFromURL("https://no.wikipedia.org/wiki/Norges_kommuner");

        // check for pattern and filter out non matching results
        for (int i = 0; i < data.size(); i++) {
            String[] link = data.get(i).split("<img");
            String imgUrl = link[0].split("href=")[1].split("class")[0];
            String ext = imgUrl.substring(imgUrl.length() - 5);
            ext = ext.substring(0, ext.length() - 2);

            // get img url
            if (ext.equals("svg")) {
                System.out.println(imgUrl);
            }
        }
    }
}
