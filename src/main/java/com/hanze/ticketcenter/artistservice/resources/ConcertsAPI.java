package com.hanze.ticketcenter.artistservice.resources;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class ConcertsAPI {
    String apiUrl = "http://api.eventful.com/json/events/";
    String appKey = "JFfNZghvjMLmbzh2";

    public String read(String method, String params) {
        String apiRequest = apiUrl + method + "?app_key=" + appKey + "&category=music" +  params;
        String string = "";

        try {
            URL url = new URL(apiRequest);
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

            String inputLine;

            while((inputLine = in.readLine()) != null) {
                string += inputLine;
                in.close();
            }
        } catch(Exception e) {
            System.err.println(e.getMessage());
        }

        return string;
    }
}
