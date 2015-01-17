package com.hanze.ticketcenter.artistservice.resources;

import com.hanze.ticketcenter.artistservice.utils.Reader;

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
    public String buildUrl(String resource, String method, String parameters) {
        return this.getApiUrl() + "/" + this.getApiFormat() + "/" + resource + "/" + method + "?app_key=" + this.getApiKey() + parameters;
    }
}
