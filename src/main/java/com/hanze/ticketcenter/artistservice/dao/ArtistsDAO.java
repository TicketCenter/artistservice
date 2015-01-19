package com.hanze.ticketcenter.artistservice.dao;

import com.hanze.ticketcenter.artistservice.dao.interfaces.ArtistsDAOInterface;
import com.hanze.ticketcenter.artistservice.resources.LastFmAPI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArtistsDAO extends LastFmAPI implements ArtistsDAOInterface {
    @Override
    public String getArtists(String characters, String pageSize, String pageNumber) {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("artist", characters);
        parameters.put("limit", pageSize);
        parameters.put("page", pageNumber);

        List<String> attributes = new ArrayList<>();
        attributes.add("results");

        return this.read("artist", "search", parameters, attributes);
    }

    @Override
    public String getArtist(String name) {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("artist", name);

        List<String> attributes = new ArrayList<>();
        attributes.add("artist");

        return this.read("artist", "getinfo", parameters, attributes);
    }
}
