package com.hanze.ticketcenter.artistservice.dao.interfaces;

/**
 * The artists DAO interface.
 *
 * @author      Nils Berlijn
 * @version     1.0
 * @since       1.0
 */
public interface ArtistsDAOInterface {
    /**
     * Get artists from the artists resource.
     *
     * @param apiKey            The api key to identify.
     * @param characters        The characters to filter by.
     * @param pageSize          The amount of artists to show per page.
     * @param pageNumber        The current page.
     * @return Artists.
     */
    public String getArtists(String apiKey, String characters, Integer pageSize, Integer pageNumber);

    /**
     * Get an artist from the artists DAO.
     *
     * @param apiKey            The api key to identify.
     * @param name              The name of the artist.
     * @return An artist.
     */
    public String getArtist(String apiKey, String name);
}
