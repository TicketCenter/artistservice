package com.hanze.ticketcenter.artistservice.resources.parsers;

import com.hanze.ticketcenter.artistservice.resources.services.LastFm;

import java.util.HashMap;
import java.util.Map;

public class ArtistsParser extends LastFm {
    public String parseArtists(String characters, String pageSize, String pageNumber) {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("artist", characters);
        parameters.put("limit", pageSize);
        parameters.put("page", pageNumber);

        return read(buildUrl("artist", "search", parameters));

        /* TODO: Parse Artists
        - Read JSON into a variable
        - Parse JSON into a DTO
        - Return a DTO
         */
    }

    public String parseArtist(String name) {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("artist", name);

        return read(buildUrl("artist", "getinfo", parameters));

        /* TODO: Parse Artist
        - Read JSON into a variable
        - Parse JSON into a DTO
        - Return a DTO
         */
    }
}
