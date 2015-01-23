package com.hanze.ticketcenter.artistservice.resources;

import com.hanze.ticketcenter.artistservice.dto.ConcertsDTO;
import com.hanze.ticketcenter.artistservice.resources.parsers.ConcertsParser;
import com.hanze.ticketcenter.artistservice.resources.services.Eventful;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * The concerts resource.
 *
 * @author      Nils Berlijn
 * @version     1.0
 * @since       1.0
 */
@Resource(name = "ConcertsResource")
public class ConcertsResource {
    /**
     * The concerts parser.
     *
     * @see                     com.hanze.ticketcenter.artistservice.resources.parsers.ConcertsParser
     */
    private final ConcertsParser concertsParser = new ConcertsParser();

    /**
     * The Eventful service.
     *
     * @see                     com.hanze.ticketcenter.artistservice.resources.services.Eventful
     */
    private final Eventful eventful = new Eventful();

    /**
     * Get concerts parsed from the Eventful service.
     *
     * @param location          The location to filter by.
     * @param pageSize          The amount of concerts to show per page.
     * @param pageNumber        The current page.
     * @return                  Concerts.
     * @see                     #concertsParser
     * @see                     #eventful
     */
    @Resource
    public ConcertsDTO getConcertsResource(String location, Integer pageSize, Integer pageNumber) {
        Map<String, Object> parameters = new LinkedHashMap<>();
        parameters.put("category", "music");
        parameters.put("location", location);
        parameters.put("page_size", pageSize);
        parameters.put("page_number", pageNumber);

        return concertsParser.parseConcerts(eventful.get("events", "search", parameters));
    }

    /**
     * Get a concert parsed from the Eventful service.
     *
     * @param id                The id of the concert.
     * @return                  A concert.
     * @see                     #concertsParser
     * @see                     #eventful
     */
    @Resource
    public ConcertsDTO getConcertResource(String id) {
        Map<String, String> parameters = new LinkedHashMap<>();
        parameters.put("id", id);

        return concertsParser.parseConcert(eventful.get("events", "get", parameters));
    }
}
