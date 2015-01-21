package com.hanze.ticketcenter.artistservice;

import com.hanze.ticketcenter.artistservice.dao.ArtistsDAO;

import javax.annotation.Resource;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * The artists resource.
 *
 * @author      Nils
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
     * @param characters        The characters to filter.
     * @param pageSize          The amount of concerts to display.
     * @param pageNumber        The current page.
     * @return                  Artists.
     * @see                     #artistsDAO#getArtists(String, Integer, Integer)
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getArtists(
            @DefaultValue("a") @QueryParam("characters") String characters,
            @DefaultValue("10") @QueryParam("page_size") Integer pageSize,
            @DefaultValue("1") @QueryParam("page_number") Integer pageNumber) {

        return artistsDAO.getArtists(characters, pageSize, pageNumber);
    }

    /**
     * Get an artist from the artists DAO.
     *
     * @param name              The name of the artist.
     * @return                  An artist.
     * @see                     #artistsDAO#getArtist(String)
     */
    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getArtist(
            @PathParam("name") String name) {

        return artistsDAO.getArtist(name);
    }
}
