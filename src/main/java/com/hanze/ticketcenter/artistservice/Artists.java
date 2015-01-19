package com.hanze.ticketcenter.artistservice;

import com.hanze.ticketcenter.artistservice.dao.ArtistsDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("artists")
public class Artists {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getArtists(
            @DefaultValue("a") @QueryParam("characters") String characters,
            @DefaultValue("") @QueryParam("page_size") String pageSize,
            @DefaultValue("") @QueryParam("page_number") String pageNumber) {

        return new ArtistsDAO().getArtists(characters, pageSize, pageNumber);
    }

    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getArtist(
            @PathParam("name") String name) {

        return new ArtistsDAO().getArtist(name);
    }
}
