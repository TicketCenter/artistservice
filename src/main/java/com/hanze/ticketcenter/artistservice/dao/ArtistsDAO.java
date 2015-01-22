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
 * @author      Nils Berlijn
 * @version     1.0
 * @since       1.0
 */
public class ArtistsDAO extends BaseDAO implements ArtistsDAOInterface {
    /**
     * The artists resource.
     *
     * @see com.hanze.ticketcenter.artistservice.resources.ArtistsResource
     */
    @Resource(name="ArtistsResource")
    private final ArtistsResource artistsResource = new ArtistsResource();

    /**
     * Get artists from the artists resource.
     *
     * @param apiKey            The api key to identify.
     * @param characters        The characters to filter by.
     * @param pageSize          The amount of artists to show per page.
     * @param pageNumber        The current page.
     * @return                  Artists.
     * @see                     #artistsResource
     */
    @Override
    public String getArtists(String apiKey, String characters, Integer pageSize, Integer pageNumber) {
        Map<String, Object> artistsMap = new LinkedHashMap<>();

        if(authenticate(apiKey)) {
            ArtistsDTO artistsDTO = artistsResource.getArtistsResource(characters, pageSize, pageNumber);

            if(artistsDTO.getArtists() != null) {
                artistsMap.putAll(statusOk());
                artistsMap.put("total_items", artistsDTO.getTotalItems());
                artistsMap.put("page_size", artistsDTO.getPageSize());
                artistsMap.put("page_number", artistsDTO.getPageNumber());
                artistsMap.put("page_count", artistsDTO.getPageCount());
                artistsMap.put("artists", artistsDTO.getArtists());
            } else {
                artistsMap.putAll(statusNotFound("There are no artists found."));
            }
        } else {
            artistsMap.putAll(statusUnauthorized());
        }

        return JSONValue.toJSONString(artistsMap);
    }

    /**
     * Get an artist from the artists DAO.
     *
     * @param apiKey            The api key to identify.
     * @param name              The name of the artist.
     * @return                  An artist.
     * @see                     #artistsResource
     */
    @Override
    public String getArtist(String apiKey, String name) {
        Map<String, Object> artistMap = new LinkedHashMap<>();

        if(authenticate(apiKey)) {
            ArtistsDTO artistsDTO = artistsResource.getArtistResource(name);

            if (artistsDTO.getArtists() != null) {
                artistMap.putAll(statusOk());
                artistMap.put("artist", artistsDTO.getArtists());
            } else {
                artistMap.putAll(statusNotFound("Artist not found."));
            }
        } else {
            artistMap.putAll(statusUnauthorized());
        }

        return JSONValue.toJSONString(artistMap);
    }
}
