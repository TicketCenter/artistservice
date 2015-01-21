package com.hanze.ticketcenter.artistservice.resources;

import com.hanze.ticketcenter.artistservice.dto.ConcertsDTO;
import com.hanze.ticketcenter.artistservice.resources.parsers.ConcertsParser;
import com.hanze.ticketcenter.artistservice.resources.services.Eventful;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.Map;

@Resource(name="ConcertsResource")
public class ConcertsResource {
    private final Eventful eventful = new Eventful();
    private final ConcertsParser concertsParser = new ConcertsParser();

    @Resource
    public ConcertsDTO getConcertsResource(String location, Integer pageSize, Integer pageNumber) {
        Map<String, Object> parameters = new LinkedHashMap<>();
        parameters.put("category", "music");
        parameters.put("location", location);
        parameters.put("page_size", pageSize);
        parameters.put("page_number", pageNumber);

        return concertsParser.parseConcerts(eventful.get("events", "search", parameters));
    }

    @Resource
    public ConcertsDTO getConcertResource(String id) {
        Map<String, String> parameters = new LinkedHashMap<>();
        parameters.put("id", id);

        return concertsParser.parseConcert(eventful.get("events", "get", parameters));
    }
}
