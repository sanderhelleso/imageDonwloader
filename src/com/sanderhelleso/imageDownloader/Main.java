package com.sanderhelleso.imageDownloader;

import java.io.IOException;

public class Main extends UrlReader {

    public static void main(String[] args) throws IOException {
	// write your code here
        String data = UrlReader.readStringFromURL("https://no.wikipedia.org/wiki/Norges_kommuner");
        System.out.println(data);
    }
}
