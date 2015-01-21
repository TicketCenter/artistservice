package com.hanze.ticketcenter.artistservice.resources.utils;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;

@SuppressWarnings("WeakerAccess")
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

    public String buildUrlParameters(Map parameters) {
        Iterator iterator = parameters.entrySet().iterator();
        String newParameters = "";

        while(iterator.hasNext()) {
            Map.Entry pairs = (Map.Entry)iterator.next();

            try {
                newParameters += "&" + pairs.getKey() + "=" + URLEncoder.encode(pairs.getValue().toString(), "UTF-8");
            } catch(UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

        return newParameters;
    }
}
