package com.hanze.ticketcenter.artistservice.utils;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;

public class Reader {
    public String read(String url) {
        try {
            InputStream inputStream = new URL(url).openStream();

            try {
                return IOUtils.toString(inputStream);
            } catch(IOException e) {
                e.printStackTrace();
            } finally {
                IOUtils.closeQuietly(inputStream);
            }
        } catch(IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public String buildUrl(String url, String resource, String method, Map parameters) {
        return url + "/" + resource + "/" + method + "/" + buildUrlParameters(parameters);
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
}
