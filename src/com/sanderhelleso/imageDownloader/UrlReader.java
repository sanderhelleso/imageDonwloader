package com.sanderhelleso.imageDownloader;

import java.io.BufferedReader;
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
}
