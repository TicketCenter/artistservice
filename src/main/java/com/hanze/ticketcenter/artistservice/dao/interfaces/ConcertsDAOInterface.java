package com.hanze.ticketcenter.artistservice.dao.interfaces;

/**
 * The concerts DAO interface.
 *
 * @author      Nils
 * @version     1.0
 * @since       1.0
 */
public interface ConcertsDAOInterface {
    /**
     * Get all the concerts from the concerts resource.
     *
     * @param location      The location to filter.
     * @param pageSize      The amount of concerts to display.
     * @param pageNumber    The current page.
     * @return              All the concerts.
     */
    public String getConcerts(String location, Integer pageSize, Integer pageNumber);

    /**
     * Get a concert from the concerts resource.
     *
     * @param id            The id of the concert.
     * @return              A concert.
     */
    public String getConcert(String id);
}
