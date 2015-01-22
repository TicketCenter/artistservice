package com.hanze.ticketcenter.artistservice.dao;

import com.hanze.ticketcenter.artistservice.config.API;

import java.util.Map;

/**
 * The base DAO.
 *
 * @author      Nils Berlijn
 * @version     1.0
 * @since       1.0
 */
@SuppressWarnings("WeakerAccess")
abstract public class BaseDAO {
    /**
     * The API config.
     *
     * @see com.hanze.ticketcenter.artistservice.config.API
     */
    private final API api = new API();

    /**
     * Get concerts from the concerts resource.
     *
     * @param apiKey            The api key to identify.
     * @param location          The location to filter.
     * @param pageSize          The amount of concerts to display.
     * @param pageNumber        The current page.
     * @return                  Concerts.
     * @see                     #concertsResource
     */

    /**
     * Identify if the API key is valid.
     *
     * @param apiKey            The API key to identify.
     * @return                  If the API key is valid.
     */
    protected boolean authenticate(String apiKey) {
        return apiKey.equals(api.getApiKey());
    }

    /**
     * Fills the map with status unauthorized information.
     *
     * @param map               The map to fill.
     */
    protected void statusUnauthorized(Map<String, Object> map) {
        map.put("status", 401);
        map.put("message", "Unauthorized");
        map.put("description", "A valid API key is required.");
    }

    /**
     * Fills the map with status ok information.
     *
     * @param map               The map to fill.
     */
    protected void statusOk(Map<String, Object> map) {
        map.put("status", 200);
        map.put("message", "OK");
    }

    /**
     * Fills the map with status not found information.
     *
     * @param map               The map to fill.
     * @param description       The description of the status.
     */
    protected void statusNotFound(Map<String, Object> map, String description) {
        map.put("status", 404);
        map.put("message", "Not Found");
        map.put("description", description);
    }
}
