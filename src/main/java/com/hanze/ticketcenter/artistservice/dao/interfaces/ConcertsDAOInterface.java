package com.hanze.ticketcenter.artistservice.dao.interfaces;

/**
 * The concerts DAO interface.
 *
 * @author Nils Berlijn
 * @version 1.0
 * @since 1.0
 */
public interface ConcertsDAOInterface {
    /**
     * Get concerts from the concerts resource.
     *
     * @param apiKey     The api key to identify.
     * @param location   The location to filter by.
     * @param pageSize   The amount of concerts to show per page.
     * @param pageNumber The current page.
     * @return Concerts.
     */
    public String getConcerts(String apiKey, String location, Integer pageSize, Integer pageNumber);

    /**
     * Get a concert from the concerts resource.
     *
     * @param apiKey The api key to identify.
     * @param id     The id of the concert.
     * @return A concert.
     */
    public String getConcert(String apiKey, String id);
}
