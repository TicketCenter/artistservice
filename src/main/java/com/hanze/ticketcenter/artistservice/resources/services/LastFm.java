package com.hanze.ticketcenter.artistservice.resources.services;

import com.hanze.ticketcenter.artistservice.resources.utils.Reader;

import java.util.Map;

public class LastFm extends Reader {
    private static final String API_URL = "http://ws.audioscrobbler.com/2.0/";
    private static final String API_KEY = "a2f47791b8c26629855c06b477ab06b4";
    private static final String API_FORMAT = "json";

    public String get(String resource, String method, Map parameters) {
        return read(API_URL + "/" + "?api_key=" + API_KEY + "&format=" + API_FORMAT + "&method=" + resource + "." + method + buildUrlParameters(parameters));
    }
}
