package com.hanze.ticketcenter.artistservice.dao;

import com.hanze.ticketcenter.artistservice.dao.interfaces.ArtistsDAOInterface;
import com.hanze.ticketcenter.artistservice.resources.parsers.ArtistsParser;

public class ArtistsDAO implements ArtistsDAOInterface {
    private final ArtistsParser artistsParser = new ArtistsParser();

    @Override
    public String getArtists(String characters, String pageSize, String pageNumber) {
        return artistsParser.parseArtists(characters, pageSize, pageNumber);

        /* TODO: Read DTO
        - Parse into a DTO variable
        - Parse DTO into a JSON variable
        - Return a JSON String
         */
    }

    @Override
    public String getArtist(String name) {
        return artistsParser.parseArtist(name);

        /* TODO: Read DTO
        - Parse into a DTO variable
        - Parse DTO into a JSON variable
        - Return a JSON String
         */
    }
}
