package com.hanze.ticketcenter.artistservice.resources;

import com.hanze.ticketcenter.artistservice.resources.services.utils.Reader;

import java.util.Map;

/**
 * LastFM service.
 *
 * @author      Nils Berlijn
 * @version     1.0
 * @since       1.0
 */
public class LastFM extends Reader {
    /**
     * The URL of the LastFM service.
     */
    private static final String API_URL = "http://ws.audioscrobbler.com/2.0/";

    /**
     * The API key of the LastFM service.
     */
    private static final String API_KEY = "a2f47791b8c26629855c06b477ab06b4";

    /**
     * The format of the LastFM service.
     */
    private static final String API_FORMAT = "json";

    /**
     * Get the data from the service.
     *
     * @param resource          The resource to get the data from.
     * @param method            The method of the resource.
     * @param parameters        The parameters for the method.
     * @return                  String.
     * @see                     #read(String)
     */
    @SuppressWarnings("SameParameterValue")
    public String get(String resource, String method, Map parameters) {
        return read(API_URL + "/" + "?api_key=" + API_KEY + "&format=" + API_FORMAT + "&method=" + resource + "." + method + buildUrlParameters(parameters));
    }
}
