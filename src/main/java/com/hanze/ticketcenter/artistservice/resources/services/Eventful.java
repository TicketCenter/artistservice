package com.hanze.ticketcenter.artistservice.resources.services;

import com.hanze.ticketcenter.artistservice.resources.utils.Reader;

import java.util.Map;

public class Eventful extends Reader {
    private static final String API_URL = "http://api.eventful.com/";
    private static final String API_KEY = "JFfNZghvjMLmbzh2";
    private static final String API_FORMAT = "json";

    @SuppressWarnings("SameParameterValue")
    public String get(String resource, String method, Map parameters) {
        return read(API_URL + "/" + API_FORMAT + "/" + resource + "/" + method + "?app_key=" + API_KEY + buildUrlParameters(parameters));
    }
}
