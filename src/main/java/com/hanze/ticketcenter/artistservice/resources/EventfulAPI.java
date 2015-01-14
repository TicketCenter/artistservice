package com.hanze.ticketcenter.artistservice.resources;

import com.hanze.ticketcenter.artistservice.utils.APIReader;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class EventfulAPI {
    private static final String API_URL = "http://api.eventful.com/json/events/";
    private static final String API_KEY = "JFfNZghvjMLmbzh2";

    public String read(String method, Map params, List remove) {
        String url = this.requestUrl(method, params);
        APIReader apiReader = new APIReader(url, "json");

        if(remove != null) {
            apiReader.removeAttributes(remove);
        }

        return apiReader.getString();
    }

    private String requestUrl(String method, Map params) {
        Iterator iterator = params.entrySet().iterator();
        String string = "";

        while(iterator.hasNext()) {
            Map.Entry pairs = (Map.Entry)iterator.next();
            string += "&" + pairs.getKey() + "=" + pairs.getValue();
        }

        return API_URL + method + "?app_key=" + API_KEY + "&category=music" + string;
    }
}
