package com.hanze.ticketcenter.artistservice.resources;

import com.hanze.ticketcenter.artistservice.dto.ArtistsDTO;
import com.hanze.ticketcenter.artistservice.resources.parsers.ArtistsParser;
import com.hanze.ticketcenter.artistservice.resources.services.LastFm;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * The artists resource.
 *
 * @author      Nils Berlijn
 * @version     1.0
 * @since       1.0
 */
@Resource(name="ArtistsResource")
public class ArtistsResource {
    /**
     * The artists parser.
     *
     * @see com.hanze.ticketcenter.artistservice.resources.parsers.ArtistsParser
     */
    private final ArtistsParser artistsParser = new ArtistsParser();

    /**
     * The LastFm service.
     *
     * @see com.hanze.ticketcenter.artistservice.resources.services.LastFm
     */
    private final LastFm lastFm = new LastFm();

    /**
     * Get artists parsed from the LastFm service.
     *
     * @param characters        The characters to filter by.
     * @param pageSize          The amount of artists to show per page.
     * @param pageNumber        The current page.
     * @return                  Artists.
     * @see                     #artistsParser
     * @see                     #lastFm
     */
    @Resource
    public ArtistsDTO getArtistsResource(String characters, Integer pageSize, Integer pageNumber) {
        Map<String, Object> parameters = new LinkedHashMap<>();
        parameters.put("artist", characters);
        parameters.put("limit", pageSize);
        parameters.put("page", pageNumber);

        return artistsParser.parseArtists(lastFm.get("artist", "search", parameters));
    }

    /**
     * Get an artist parsed from the LastFm service.
     *
     * @param name              The name of the artist.
     * @return                  An artist.
     * @see                     #artistsParser
     * @see                     #lastFm
     */
    @Resource
    public ArtistsDTO getArtistResource(String name) {
        Map<String, String> parameters = new LinkedHashMap<>();
        parameters.put("artist", name);

        return artistsParser.parseArtist(lastFm.get("artist", "getinfo", parameters));
    }
}
