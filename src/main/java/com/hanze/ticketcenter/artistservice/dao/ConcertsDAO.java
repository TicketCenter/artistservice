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
 * @author      Nils
 * @version     1.0
 * @since       1.0
 */
public class ConcertsDAO implements ConcertsDAOInterface {
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
     * @param location          The location to filter.
     * @param pageSize          The amount of concerts to display.
     * @param pageNumber        The current page.
     * @return                  Concerts.
     * @see                     #concertsResource
     */
    @Override
    public String getConcerts(String location, Integer pageSize, Integer pageNumber) {
        ConcertsDTO concertsDTO = concertsResource.getConcertsResource(location, pageSize, pageNumber);
        Map<String, Object> concertsMap = new LinkedHashMap<>();

        if(concertsDTO.getConcerts() != null) {
            concertsMap.put("status", 200);
            concertsMap.put("message", "OK");
            concertsMap.put("total_items", concertsDTO.getTotalItems());
            concertsMap.put("page_size", concertsDTO.getPageSize());
            concertsMap.put("page_number", concertsDTO.getPageNumber());
            concertsMap.put("page_count", concertsDTO.getPageCount());
            concertsMap.put("concerts", concertsDTO.getConcerts());
        } else {
            concertsMap.put("status", 404);
            concertsMap.put("message", "Not Found");
            concertsMap.put("description", "There are no concerts found.");
        }

        return JSONValue.toJSONString(concertsMap);
    }

    /**
     * Get a concert from the concerts resource.
     *
     * @param id                The id of the concert.
     * @return                  A concert.
     * @see                     #concertsResource
     */
    @Override
    public String getConcert(String id) {
        ConcertsDTO concertsDTO = concertsResource.getConcertResource(id);
        Map<String, Object> concertMap = new LinkedHashMap<>();

        if(concertsDTO.getConcerts() != null) {
            concertMap.put("status", 200);
            concertMap.put("message", "OK");
            concertMap.put("concert", concertsDTO.getConcerts());
        } else {
            concertMap.put("status", 404);
            concertMap.put("message", "Not Found");
            concertMap.put("description", "Concert not found.");
        }

        return JSONValue.toJSONString(concertMap);
    }
}
