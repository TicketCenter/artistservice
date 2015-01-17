package com.hanze.ticketcenter.artistservice;

import com.hanze.ticketcenter.artistservice.dao.ArtistsDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("artists")
public class Artists {
    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getConcert(
            @PathParam("name") String name) {

        return new ArtistsDAO().getArtist(name);
    }
}
