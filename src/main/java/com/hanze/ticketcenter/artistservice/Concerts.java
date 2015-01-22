package com.hanze.ticketcenter.artistservice;

import com.hanze.ticketcenter.artistservice.dao.ConcertsDAO;

import javax.annotation.Resource;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * The concerts resource.
 *
 * @author Nils Berlijn
 * @version 1.0
 * @since 1.0
 */
@SuppressWarnings("WeakerAccess")
@Path("concerts")
public class Concerts {
    /**
     * The concerts DAO.
     *
     * @see com.hanze.ticketcenter.artistservice.dao.ConcertsDAO
     */
    @Resource
    private final ConcertsDAO concertsDAO = new ConcertsDAO();

    /**
     * Get concerts from the Concerts DAO.
     *
     * @param apiKey     The api key to identify.
     * @param location   The location to filter by.
     * @param pageSize   The amount of concerts to show per page.
     * @param pageNumber The current page.
     * @return Concerts.
     * @see #concertsDAO
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getConcerts(
            @DefaultValue("") @QueryParam("api_key") String apiKey,
            @DefaultValue("") @QueryParam("location") String location,
            @DefaultValue("10") @QueryParam("page_size") Integer pageSize,
            @DefaultValue("1") @QueryParam("page_number") Integer pageNumber) {

        return concertsDAO.getConcerts(apiKey, location, pageSize, pageNumber);
    }

    /**
     * Get a concert from the concerts DAO.
     *
     * @param apiKey The api key to identify.
     * @param id     The id of the concert.
     * @return A concert.
     * @see #concertsDAO
     */
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getConcert(
            @DefaultValue("") @QueryParam("api_key") String apiKey,
            @DefaultValue("") @PathParam("id") String id) {

        return concertsDAO.getConcert(apiKey, id);
    }
}
