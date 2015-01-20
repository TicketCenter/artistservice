package com.hanze.ticketcenter.artistservice;

import com.hanze.ticketcenter.artistservice.dao.ArtistsDAO;

import javax.annotation.Resource;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("artists")
public class Artists {
    @Resource
    private ArtistsDAO artistsDAO = new ArtistsDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getArtists(
            @DefaultValue("a") @QueryParam("characters") String characters,
            @DefaultValue("10") @QueryParam("page_size") String pageSize,
            @DefaultValue("1") @QueryParam("page_number") String pageNumber) {

        return artistsDAO.getArtists(characters, pageSize, pageNumber);
    }

    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getArtist(
            @PathParam("name") String name) {

        return artistsDAO.getArtist(name);
    }
}
