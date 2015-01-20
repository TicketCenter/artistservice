package com.hanze.ticketcenter.artistservice.dao.interfaces;

public interface ConcertsDAOInterface {
    public String getConcerts(String location, Integer pageSize, Integer pageNumber);
    public String getConcert(String id);
}
