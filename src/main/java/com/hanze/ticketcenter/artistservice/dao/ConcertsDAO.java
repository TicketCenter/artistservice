package com.hanze.ticketcenter.artistservice.dao;

import com.hanze.ticketcenter.artistservice.dao.interfaces.ConcertsDAOInterface;
import com.hanze.ticketcenter.artistservice.resources.internal.ConcertsData;

import java.util.HashMap;
import java.util.Map;

public class ConcertsDAO extends ConcertsData implements ConcertsDAOInterface {
    @Override
    public String getConcerts(String location, String pageSize, String pageNumber) {
        Map<String, String> parameters = new HashMap<>();
            parameters.put("category", "music");
            parameters.put("location", location);
            parameters.put("page_size", pageSize);
            parameters.put("page_number", pageNumber);

        return this.concertsSource(parameters);
    }

    @Override
    public String getConcert(String id) {
        Map<String, String> parameters = new HashMap<>();
            parameters.put("id", id);

        return this.concertSource(parameters);
    }
}
