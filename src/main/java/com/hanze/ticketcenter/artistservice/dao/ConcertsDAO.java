package com.hanze.ticketcenter.artistservice.dao;

import com.hanze.ticketcenter.artistservice.dao.interfaces.ConcertsDAOInterface;
import com.hanze.ticketcenter.artistservice.resources.eventful.ConcertsParser;

public class ConcertsDAO extends ConcertsParser implements ConcertsDAOInterface {
    @Override
    public String getConcerts(String location, String pageSize, String pageNumber) {
        return concertsParser(location, pageSize, pageNumber);
    }

    @Override
    public String getConcert(String id) {
        return concertParser(id);
    }
}
