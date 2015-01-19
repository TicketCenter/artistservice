package com.hanze.ticketcenter.artistservice.resources;

import com.hanze.ticketcenter.artistservice.utils.Reader;

import java.util.Map;

abstract public class EventfulAPI extends Reader {
    private static final String API_URL = "http://api.eventful.com/";
    private static final String API_KEY = "JFfNZghvjMLmbzh2";
    private static final String API_FORMAT = "json";

    public EventfulAPI() {
        this.setApiUrl(API_URL);
        this.setApiKey(API_KEY);
        this.setApiFormat(API_FORMAT);
    }

    @Override
    public String buildUrl(String resource, String method, Map parameters) {
        return this.getApiUrl() + "/" + this.getApiFormat() + "/" + resource + "/" + method + "?app_key=" + this.getApiKey() + this.buildUrlParameters(parameters);
    }
}
