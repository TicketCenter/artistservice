package com.hanze.ticketcenter.artistservice;

import com.hanze.ticketcenter.artistservice.dao.ConcertsDAO;

import javax.annotation.Resource;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@SuppressWarnings("WeakerAccess")
@Path("concerts")
public class Concerts {
    @Resource
    private final ConcertsDAO concertsDAO = new ConcertsDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getConcerts(
            @DefaultValue("") @QueryParam("location") String location,
            @DefaultValue("10") @QueryParam("page_size") Integer pageSize,
            @DefaultValue("1") @QueryParam("page_number") Integer pageNumber) {

        return concertsDAO.getConcerts(location, pageSize, pageNumber);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getConcert(
            @PathParam("id") String id) {

        return concertsDAO.getConcert(id);
    }
}
