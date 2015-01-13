package com.hanze.ticketcenter.artistservice;

import com.hanze.ticketcenter.artistservice.resources.ConcertsAPI;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("concerts")
public class Concerts {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getConcerts(
            @DefaultValue("Netherlands") @QueryParam("location") String location,
            @DefaultValue("10") @QueryParam("page_size") String pageSize,
            @DefaultValue("1") @QueryParam("page_number") String pageNumber) {

        String params = "&location=" + location +
                "&page_size=" + pageSize +
                "&page_number=" + pageNumber;

        return new ConcertsAPI().read("search", params);
    }

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public String getConcert(
            @QueryParam("id") String id) {

        String params = "&id=" + id;

        return new ConcertsAPI().read("get", params);
    }
}
