package com.hanze.ticketcenter.artistservice.dao;

import com.hanze.ticketcenter.artistservice.dao.interfaces.ArtistsDAOInterface;
import com.hanze.ticketcenter.artistservice.dto.ArtistsDTO;
import com.hanze.ticketcenter.artistservice.resources.ArtistsResource;
import org.json.simple.JSONValue;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.Map;

public class ArtistsDAO implements ArtistsDAOInterface {
    @Resource(name="ArtistsResource")
    private final ArtistsResource artistsResource = new ArtistsResource();

    @Override
    public String getArtists(String characters, Integer pageSize, Integer pageNumber) {
        ArtistsDTO artistsDTO = artistsResource.getArtistsResource(characters, pageSize, pageNumber);
        Map<String, Object> artistsMap = new LinkedHashMap<>();

        if(artistsDTO.getArtists() != null) {
            artistsMap.put("status", 200);
            artistsMap.put("message", "OK");
            artistsMap.put("total_items", artistsDTO.getTotalItems());
            artistsMap.put("page_size", artistsDTO.getPageSize());
            artistsMap.put("page_number", artistsDTO.getPageNumber());
            artistsMap.put("page_count", artistsDTO.getPageCount());
            artistsMap.put("artists", artistsDTO.getArtists());
        } else {
            artistsMap.put("status", 404);
            artistsMap.put("message", "Not Found");
            artistsMap.put("description", "There are no artists found.");
        }

        return JSONValue.toJSONString(artistsMap);
    }

    @Override
    public String getArtist(String name) {
        ArtistsDTO artistsDTO = artistsResource.getArtistResource(name);
        Map<String, Object> artistMap = new LinkedHashMap<>();

        if(artistsDTO.getArtists() != null) {
            artistMap.put("status", 200);
            artistMap.put("message", "OK");
            artistMap.put("artist", artistsDTO.getArtists());
        } else {
            artistMap.put("status", 404);
            artistMap.put("message", "Not Found");
            artistMap.put("description", "Artist not found.");
        }

        return JSONValue.toJSONString(artistMap);
    }
}
