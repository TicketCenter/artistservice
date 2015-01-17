package com.hanze.ticketcenter.artistservice.resources;

import com.hanze.ticketcenter.artistservice.utils.Reader;

abstract public class LastfmAPI extends Reader {
    private static final String API_URL = "http://ws.audioscrobbler.com/2.0/";
    private static final String API_KEY = "a2f47791b8c26629855c06b477ab06b4";
    private static final String API_FORMAT = "json";

    public LastfmAPI() {
        this.setApiUrl(API_URL);
        this.setApiKey(API_KEY);
        this.setApiFormat(API_FORMAT);
    }

    @Override
    public String buildUrl(String resource, String method, String parameters) {
        return this.getApiUrl() + "/" + "?api_key=" + this.getApiKey() + "&format=" + this.getApiFormat() + "&method=" + resource + "." + method + parameters;
    }
}
