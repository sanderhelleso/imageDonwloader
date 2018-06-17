package com.sanderhelleso.imageDownloader;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
	    // array with lines from url
        ArrayList<String> data = UrlReader.readStringFromURL("https://no.wikipedia.org/wiki/Norges_kommuner");
        ArrayList<String> imgData;

        // wikipedia domain
        String domain = "https://no.wikipedia.org";

        // check for pattern and filter out non matching results
        UrlReader.getUrlSrc(domain, data);
    }
}
