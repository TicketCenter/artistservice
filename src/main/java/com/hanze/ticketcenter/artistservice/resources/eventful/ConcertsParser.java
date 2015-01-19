package com.hanze.ticketcenter.artistservice.resources.eventful;

import com.hanze.ticketcenter.artistservice.utils.Reader;

import java.util.HashMap;
import java.util.Map;

public class ConcertsParser extends Reader {
    private static final String API_URL = "http://api.eventful.com/";
    private static final String API_KEY = "JFfNZghvjMLmbzh2";
    private static final String API_FORMAT = "json";

    public String concertsParser(String location, String pageSize, String pageNumber) {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("category", "music");
        parameters.put("location", location);
        parameters.put("page_size", pageSize);
        parameters.put("page_number", pageNumber);

        String concerts = read(buildUrl(API_URL, "events", "search", parameters));

        // TODO: Parse concerts
        // BEGIN PARSE
        String concertsParsed = concerts.toString();
        // END PARSE

        return concertsParsed;
    }

    public String concertParser(String id) {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("id", id);

        String concert = read(buildUrl(API_URL, "events", "get", parameters));

        // TODO: Parse concert
        // BEGIN PARSE
        String concertParsed = concert.toString();
        // END PARSE

        return concertParsed;
    }

    @Override
    public String buildUrl(String url, String resource, String method, Map parameters) {
        return url + "/" + API_FORMAT + "/" + resource + "/" + method + "?app_key=" + API_KEY + buildUrlParameters(parameters);
    }
}
