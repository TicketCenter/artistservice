package com.hanze.ticketcenter.artistservice.dao;

import com.hanze.ticketcenter.artistservice.dao.interfaces.ArtistsDAOInterface;
import com.hanze.ticketcenter.artistservice.resources.lastfm.ArtistsParser;

public class ArtistsDAO extends ArtistsParser implements ArtistsDAOInterface {
    @Override
    public String getArtists(String characters, String pageSize, String pageNumber) {
        return artistsParser(characters, pageSize, pageNumber);
    }

    @Override
    public String getArtist(String name) {
        return artistParser(name);
    }
}
