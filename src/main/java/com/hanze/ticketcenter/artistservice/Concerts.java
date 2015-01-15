package com.hanze.ticketcenter.artistservice;

import com.hanze.ticketcenter.artistservice.dao.ConcertsDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("concerts")
public class Concerts {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getConcerts(
            @DefaultValue("") @QueryParam("location") String location,
            @DefaultValue("") @QueryParam("page_size") String pageSize,
            @DefaultValue("") @QueryParam("page_number") String pageNumber) {

        return new ConcertsDAO().getConcerts(location, pageSize, pageNumber);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getConcert(
            @PathParam("id") String id) {

        return new ConcertsDAO().getConcert(id);
    }
}
