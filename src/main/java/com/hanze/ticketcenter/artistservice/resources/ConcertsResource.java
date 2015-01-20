package com.hanze.ticketcenter.artistservice.resources;

import com.hanze.ticketcenter.artistservice.dto.ConcertsDTO;
import com.hanze.ticketcenter.artistservice.resources.parsers.ConcertsParser;
import com.hanze.ticketcenter.artistservice.resources.services.Eventful;

import java.util.HashMap;
import java.util.Map;

public class ConcertsResource {
    private Eventful eventful = new Eventful();
    private ConcertsParser concertsParser = new ConcertsParser();

    public ConcertsDTO getConcertsResource(String location, String pageSize, String pageNumber) {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("category", "music");
        parameters.put("location", location);
        parameters.put("page_size", pageSize);
        parameters.put("page_number", pageNumber);

        return concertsParser.parseConcerts(eventful.get("events", "search", parameters));
    }

    public ConcertsDTO getConcertResource(String id) {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("id", id);

        return concertsParser.parseConcert(eventful.get("events", "get", parameters));
    }
}
