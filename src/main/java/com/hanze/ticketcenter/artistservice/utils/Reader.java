package com.hanze.ticketcenter.artistservice.utils;

import com.hanze.ticketcenter.artistservice.utils.api.APIReader;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

abstract public class Reader extends APIReader {
    private String apiUrl;
    private String apiKey;
    private String apiFormat;

    public String read(String resource, String method, Map parameters, List attributes) {
        String url = this.buildUrl(resource, method, buildUrlParameters(parameters));

        try {
            return this.readApi(url, attributes);
        } catch(IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public String buildUrlParameters(Map parameters) {
        Iterator iterator = parameters.entrySet().iterator();
        String newParameters = "";

        while(iterator.hasNext()) {
            Map.Entry pairs = (Map.Entry)iterator.next();
            newParameters += "&" + pairs.getKey() + "=" + pairs.getValue();
        }

        return newParameters;
    }

    public String buildUrl(String resource, String method, String parameters) {
        return this.getApiUrl() + "/" + this.getApiFormat() + "/" + resource + "/" + method + "?app_key=" + this.getApiKey() + parameters;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getApiFormat() {
        return apiFormat;
    }

    public void setApiFormat(String apiFormat) {
        this.apiFormat = apiFormat;
    }
}
