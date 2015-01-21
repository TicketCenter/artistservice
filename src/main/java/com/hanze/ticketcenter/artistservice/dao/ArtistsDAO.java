package com.hanze.ticketcenter.artistservice.dao;

import com.hanze.ticketcenter.artistservice.dao.interfaces.ArtistsDAOInterface;
import com.hanze.ticketcenter.artistservice.dto.ArtistsDTO;
import com.hanze.ticketcenter.artistservice.resources.ArtistsResource;
import org.json.simple.JSONValue;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * The artists DAO.
 *
 * @author      Nils
 * @version     1.0
 * @since       1.0
 */
public class ArtistsDAO implements ArtistsDAOInterface {
    /**
     * The artists resource.
     *
     * @see com.hanze.ticketcenter.artistservice.resources.ArtistsResource
     */
    @Resource(name="ArtistsResource")
    private final ArtistsResource artistsResource = new ArtistsResource();

    /**
     * Get all the artists from the artists resource.
     *
     * @param characters    The characters to filter.
     * @param pageSize      The amount of concerts to display.
     * @param pageNumber    The current page.
     * @return              All the artists.
     * @see                 #artistsResource#getArtists(String, Integer, Integer)
     */
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

    /**
     * Get a artist from the artists DAO.
     *
     * @param name          The name of the artist.
     * @return              A artist.
     * @see                 #artistsResource#getArtist(String)
     */
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
