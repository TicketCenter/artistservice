package com.hanze.ticketcenter.artistservice.resources.parsers;

import com.hanze.ticketcenter.artistservice.resources.services.LastFm;

import java.util.HashMap;
import java.util.Map;

public class ArtistsParser {
    private final LastFm lastFm = new LastFm();

    public String parseArtists(String characters, String pageSize, String pageNumber) {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("artist", characters);
        parameters.put("limit", pageSize);
        parameters.put("page", pageNumber);

        return lastFm.get("artist", "search", parameters);

        // TODO
    }

    public String parseArtist(String name) {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("artist", name);

        return lastFm.get("artist", "getinfo", parameters);

        // TODO
    }
}
