package com.hanze.ticketcenter.artistservice.dao;

import com.hanze.ticketcenter.artistservice.config.API;

import java.util.LinkedHashMap;
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
     * Identify if the API key is valid.
     *
     * @param apiKey            The API key to identify.
     * @return                  If the API key is valid.
     */
    protected boolean authenticate(String apiKey) {
        return apiKey.equals(api.getApiKey());
    }

    /**
     * Information about the status unauthorized.
     *
     * @return                  Status unauthorized information.
     */
    protected Map<String, Object> statusUnauthorized() {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("status", 401);
        map.put("message", "Unauthorized");
        map.put("description", "A valid API key is required.");

        return map;
    }

    /**
     * Information about the status ok.
     *
     * @return                  Status ok information.
     */
    protected Map<String, Object> statusOk() {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("status", 200);
        map.put("message", "OK");

        return map;
    }

    /**
     * Information about the status not found.
     *
     * @param description       The description of the status.
     * @return                  Status not found information.
     */
    protected Map<String, Object> statusNotFound(String description) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("status", 404);
        map.put("message", "Not Found");
        map.put("description", description);

        return map;
    }
}
