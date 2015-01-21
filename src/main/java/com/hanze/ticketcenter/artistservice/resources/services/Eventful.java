package com.hanze.ticketcenter.artistservice.resources.services;

import com.hanze.ticketcenter.artistservice.resources.utils.Reader;

import java.util.Map;

/**
 * Eventful service.
 *
 * @author      Nils
 * @version     1.0
 * @since       1.0
 */
public class Eventful extends Reader {
    /**
     * The URL of the Eventful Service.
     */
    private static final String API_URL = "http://api.eventful.com/";

    /**
     * The API key of the Eventful Service.
     */
    private static final String API_KEY = "JFfNZghvjMLmbzh2";

    /**
     * The format of the Eventful Service.
     */
    private static final String API_FORMAT = "json";

    /**
     * Get the data from the service.
     *
     * @param resource      The resource to get the data from.
     * @param method        The method of the resource.
     * @param parameters    The parameters for the method.
     * @return              String.
     * @see                 #read(String)
     */
    @SuppressWarnings("SameParameterValue")
    public String get(String resource, String method, Map parameters) {
        return read(API_URL + "/" + API_FORMAT + "/" + resource + "/" + method + "?app_key=" + API_KEY + buildUrlParameters(parameters));
    }
}
