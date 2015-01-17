package com.hanze.ticketcenter.artistservice.dao;

import com.hanze.ticketcenter.artistservice.dao.interfaces.ArtistsDAOInterface;
import com.hanze.ticketcenter.artistservice.resources.LastfmAPI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArtistsDAO extends LastfmAPI implements ArtistsDAOInterface {
    public String getArtist(String name) {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("artist", name);

        List<String> attributes = new ArrayList<>();
        attributes.add("artist");

        return this.read("artist", "getinfo", parameters, attributes);
    }
}
