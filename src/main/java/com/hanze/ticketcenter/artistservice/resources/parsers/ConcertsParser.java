package com.hanze.ticketcenter.artistservice.resources.parsers;

import com.hanze.ticketcenter.artistservice.resources.services.Eventful;

import java.util.HashMap;
import java.util.Map;

public class ConcertsParser extends Eventful {
    public String parseConcerts(String location, String pageSize, String pageNumber) {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("category", "music");
        parameters.put("location", location);
        parameters.put("page_size", pageSize);
        parameters.put("page_number", pageNumber);

        return read(buildUrl("events", "search", parameters));

        /* TODO: Parse Concerts
        - Read JSON into a variable
        - Parse JSON into a DTO
        - Return a DTO
         */
    }

    public String parseConcert(String id) {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("id", id);

        return read(buildUrl("events", "get", parameters));

        /* TODO: Parse Cncert
        - Read JSON into a variable
        - Parse JSON into a DTO
        - Return a DTO
         */
    }
}
