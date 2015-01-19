package com.hanze.ticketcenter.artistservice.resources.services;

import com.hanze.ticketcenter.artistservice.resources.utils.Reader;

import java.util.Map;

public class Eventful extends Reader {
    private static final String API_URL = "http://api.eventful.com/";
    private static final String API_KEY = "JFfNZghvjMLmbzh2";
    private static final String API_FORMAT = "json";

    public String buildUrl(String resource, String method, Map parameters) {
        return buildUrl(API_URL, resource, method, parameters);
    }

    @Override
    public String buildUrl(String url, String resource, String method, Map parameters) {
        return url + "/" + API_FORMAT + "/" + resource + "/" + method + "?app_key=" + API_KEY + buildUrlParameters(parameters);
    }
}
