package com.hanze.ticketcenter.artistservice.resources.lastfm;

import com.hanze.ticketcenter.artistservice.utils.Reader;

import java.util.HashMap;
import java.util.Map;

public class ArtistsParser extends Reader {
    private static final String API_URL = "http://ws.audioscrobbler.com/2.0/";
    private static final String API_KEY = "a2f47791b8c26629855c06b477ab06b4";
    private static final String API_FORMAT = "json";

    public String artistsParser(String characters, String pageSize, String pageNumber) {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("artist", characters);
        parameters.put("limit", pageSize);
        parameters.put("page", pageNumber);

        String artists = read(buildUrl(API_URL, "artist", "search", parameters));

        // TODO: Parse artists
        // BEGIN PARSE
        String artistsParsed = artists.toString();
        // END PARSE

        return artistsParsed;
    }

    public String artistParser(String name) {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("artist", name);

        String artist = read(buildUrl(API_URL, "artist", "getinfo", parameters));

        // TODO: Parse concert
        // BEGIN PARSE
        String artistParsed = artist.toString();
        // END PARSE

        return artistParsed;
    }

    @Override
    public String buildUrl(String url, String resource, String method, Map parameters) {
        return url + "/" + "?api_key=" + API_KEY + "&format=" + API_FORMAT + "&method=" + resource + "." + method + buildUrlParameters(parameters);
    }
}
