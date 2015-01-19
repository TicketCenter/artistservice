package com.hanze.ticketcenter.artistservice.dao;

import com.hanze.ticketcenter.artistservice.dao.interfaces.ConcertsDAOInterface;
import com.hanze.ticketcenter.artistservice.resources.parsers.ConcertsParser;

public class ConcertsDAO implements ConcertsDAOInterface {
    private ConcertsParser concertsParser = new ConcertsParser();

    @Override
    public String getConcerts(String location, String pageSize, String pageNumber) {
        return concertsParser.parseConcerts(location, pageSize, pageNumber);

        /* TODO: Read DTO
        - Parse into a DTO variable
        - Parse DTO into a JSON variable
        - Return a JSON String
         */

        /* DEMO:
        ConcertsDTO concertsDTO = concertsParser.parseConcerts(location, pageSize, pageNumber);
        Map concerts = new LinkedHashMap();
        concerts.put("country_name", concertsDTO.getCountryName());
        concerts.put("events", concertsDTO.getEvents());

        return JSONValue.toJSONString(concerts);
         */
    }

    @Override
    public String getConcert(String id) {
        return concertsParser.parseConcert(id);

        /* TODO: Read DTO
        - Parse into a DTO variable
        - Parse DTO into a JSON variable
        - Return a JSON String
         */
    }
}
