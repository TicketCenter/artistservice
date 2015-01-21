package com.hanze.ticketcenter.artistservice.resources.utils;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;

/**
 * The reader.
 *
 * @author      Nils
 * @version     1.0
 * @since       1.0
 */
@SuppressWarnings("WeakerAccess")
public class Reader {
    /**
     * Read the URL into a string.
     *
     * @param url           The url to read.
     * @return              A string or nothing if the source doesn't exists.
     */
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

    /**
     * Build URL parameters.
     *
     * @param parameters    The parameters to build.
     * @return              Made URL parameters.
     */
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
