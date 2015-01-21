package com.hanze.ticketcenter.artistservice.dao.interfaces;

public interface ArtistsDAOInterface {
    public String getArtists(String characters, Integer pageSize, Integer pageNumber);
    public String getArtist(String name);
}
