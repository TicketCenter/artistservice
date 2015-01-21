package com.hanze.ticketcenter.artistservice.resources;

import com.hanze.ticketcenter.artistservice.dto.ArtistsDTO;
import com.hanze.ticketcenter.artistservice.resources.parsers.ArtistsParser;
import com.hanze.ticketcenter.artistservice.resources.services.LastFm;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.Map;

@Resource(name="ArtistsResource")
public class ArtistsResource {
    private final LastFm lastFm = new LastFm();
    private final ArtistsParser artistsParser = new ArtistsParser();

    @Resource
    public ArtistsDTO getArtistsResource(String characters, Integer pageSize, Integer pageNumber) {
        Map<String, Object> parameters = new LinkedHashMap<>();
        parameters.put("artist", characters);
        parameters.put("limit", pageSize);
        parameters.put("page", pageNumber);

        return artistsParser.parseArtists(lastFm.get("artist", "search", parameters));
    }

    @Resource
    public ArtistsDTO getArtistResource(String name) {
        Map<String, String> parameters = new LinkedHashMap<>();
        parameters.put("artist", name);

        return artistsParser.parseArtist(lastFm.get("artist", "getinfo", parameters));
    }
}
