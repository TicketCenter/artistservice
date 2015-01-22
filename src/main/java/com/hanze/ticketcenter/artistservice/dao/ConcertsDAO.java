package com.hanze.ticketcenter.artistservice.dao;

import com.hanze.ticketcenter.artistservice.dao.interfaces.ConcertsDAOInterface;
import com.hanze.ticketcenter.artistservice.dto.ConcertsDTO;
import com.hanze.ticketcenter.artistservice.resources.ConcertsResource;
import org.json.simple.JSONValue;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * The concerts DAO.
 *
 * @author      Nils Berlijn
 * @version     1.0
 * @since       1.0
 */
public class ConcertsDAO extends BaseDAO implements ConcertsDAOInterface {
    /**
     * The concerts resource.
     *
     * @see com.hanze.ticketcenter.artistservice.resources.ConcertsResource
     */
    @Resource(name="ConcertsResource")
    private final ConcertsResource concertsResource = new ConcertsResource();

    /**
     * Get concerts from the concerts resource.
     *
     * @param apiKey            The api key to identify.
     * @param location          The location to filter by.
     * @param pageSize          The amount of concerts to show per page.
     * @param pageNumber        The current page.
     * @return                  Concerts.
     * @see                     #concertsResource
     */
    @Override
    public String getConcerts(String apiKey, String location, Integer pageSize, Integer pageNumber) {
        Map<String, Object> concertsMap = new LinkedHashMap<>();

        if(authenticate(apiKey)) {
            ConcertsDTO concertsDTO = concertsResource.getConcertsResource(location, pageSize, pageNumber);

            if(concertsDTO.getConcerts() != null) {
                concertsMap.putAll(statusOk());
                concertsMap.put("total_items", concertsDTO.getTotalItems());
                concertsMap.put("page_size", concertsDTO.getPageSize());
                concertsMap.put("page_number", concertsDTO.getPageNumber());
                concertsMap.put("page_count", concertsDTO.getPageCount());
                concertsMap.put("concerts", concertsDTO.getConcerts());
            } else {
                concertsMap.putAll(statusNotFound("There are no concerts found."));
            }
        } else {
            concertsMap.putAll(statusUnauthorized());
        }

        return JSONValue.toJSONString(concertsMap);
    }

    /**
     * Get a concert from the concerts resource.
     *
     * @param apiKey            The api key to identify.
     * @param id                The id of the concert.
     * @return                  A concert.
     * @see                     #concertsResource
     */
    @Override
    public String getConcert(String apiKey, String id) {
        Map<String, Object> concertMap = new LinkedHashMap<>();

        if(authenticate(apiKey)) {
            ConcertsDTO concertsDTO = concertsResource.getConcertResource(id);

            if(concertsDTO.getConcerts() != null) {
                concertMap.putAll((statusOk()));
                concertMap.put("concert", concertsDTO.getConcerts());
            } else {
                concertMap.putAll(statusNotFound("Concert not found."));
            }
        } else {
            concertMap.putAll(statusUnauthorized());
        }

        return JSONValue.toJSONString(concertMap);
    }
}
