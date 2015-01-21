package com.hanze.ticketcenter.artistservice.dao.interfaces;

/**
 * The artists DAO interface.
 *
 * @author      Nils
 * @version     1.0
 * @since       1.0
 */
public interface ArtistsDAOInterface {
    /**
     * Get all the artists from the artists resource.
     *
     * @param characters    The characters to filter.
     * @param pageSize      The amount of concerts to display.
     * @param pageNumber    The current page.
     * @return              All the artists.
     */
    public String getArtists(String characters, Integer pageSize, Integer pageNumber);

    /**
     * Get a artist from the artists DAO.
     *
     * @param name          The name of the artist.
     * @return              A artist.
     */
    public String getArtist(String name);
}
