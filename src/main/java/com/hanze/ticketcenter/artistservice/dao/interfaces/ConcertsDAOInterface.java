package com.hanze.ticketcenter.artistservice.dao.interfaces;

public interface ConcertsDAOInterface {
    public String getConcerts(String location, String pageSize, String pageNumber);
    public String getConcert(String id);
}
