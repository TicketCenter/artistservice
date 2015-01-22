package com.hanze.ticketcenter.artistservice;

import com.hanze.ticketcenter.artistservice.dao.ArtistsDAO;

import javax.annotation.Resource;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * The artists resource.
 *
 * @author      Nils Berlijn
 * @version     1.0
 * @since       1.0
 */
@SuppressWarnings("WeakerAccess")
@Path("artists")
public class Artists {
    /**
     * The artists DAO.
     *
     * @see com.hanze.ticketcenter.artistservice.dao.ArtistsDAO
     */
    @Resource
    private final ArtistsDAO artistsDAO = new ArtistsDAO();

    /**
     * Get artists from the artists DAO.
     *
     * @param apiKey            The api key to identify.
     * @param characters        The characters to filter by.
     * @param pageSize          The amount of artists to show per page.
     * @param pageNumber        The current page.
     * @return                  Artists.
     * @see                     #artistsDAO
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getArtists(
            @DefaultValue("") @QueryParam("api_key") String apiKey,
            @DefaultValue("a") @QueryParam("characters") String characters,
            @DefaultValue("10") @QueryParam("page_size") Integer pageSize,
            @DefaultValue("1") @QueryParam("page_number") Integer pageNumber) {

        return artistsDAO.getArtists(apiKey, characters, pageSize, pageNumber);
    }

    /**
     * Get an artist from the artists DAO.
     *
     * @param apiKey            The api key to identify.
     * @param name              The name of the artist.
     * @return                  An artist.
     * @see                     #artistsDAO
     */
    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getArtist(
            @DefaultValue("") @QueryParam("api_key") String apiKey,
            @DefaultValue("") @PathParam("name") String name) {

        return artistsDAO.getArtist(apiKey, name);
    }
}
