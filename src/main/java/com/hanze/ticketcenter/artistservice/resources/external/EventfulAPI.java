package com.hanze.ticketcenter.artistservice.resources.external;

import com.hanze.ticketcenter.artistservice.utils.APIReader;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

abstract public class EventfulAPI {
    private static final String API_URL = "http://api.eventful.com/";
    private static final String API_KEY = "JFfNZghvjMLmbzh2";
    private static final String API_FORMAT = "json";

    public String read(String resource, String method, Map params, List remove) {
        String url = this.url(resource, method, params);
        APIReader apiReader = new APIReader(url, API_FORMAT);

        try {
            apiReader.read();
        } catch(IOException e) {
            e.printStackTrace();
        }

        if(remove != null) {
            apiReader.removeAttributes(remove);
        }

        return apiReader.getString();
    }

    private String url(String resource, String method, Map params) {
        Iterator iterator = params.entrySet().iterator();
        String string = "";

        while(iterator.hasNext()) {
            Map.Entry pairs = (Map.Entry)iterator.next();
            string += "&" + pairs.getKey() + "=" + pairs.getValue();
        }

        return API_URL + "/" + API_FORMAT + "/" + resource + "/" + method + "?app_key=" + API_KEY + string;
    }
}
