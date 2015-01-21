package com.hanze.ticketcenter.artistservice.resources.parsers;

import com.hanze.ticketcenter.artistservice.dto.ConcertsDTO;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.text.DecimalFormat;
import java.util.*;

/**
 * The concerts parser.
 *
 * @author      Nils
 * @version     1.0
 * @since       1.0
 */
public class ConcertsParser {
    /**
     * Parse concerts into a concerts DTO.
     *
     * @param concerts          The concerts to parse.
     * @return                  A concerts DTO.
     * @see                     com.hanze.ticketcenter.artistservice.dto.ConcertsDTO
     */
    public ConcertsDTO parseConcerts(String concerts) {
        ConcertsDTO concertsDTO = new ConcertsDTO();

        try {
            JSONObject oldConcerts = (JSONObject) new JSONParser().parse(concerts);

            if(!oldConcerts.get("total_items").equals("0")) {
                concertsDTO.setTotalItems(Integer.parseInt((String) oldConcerts.get("total_items")));
                concertsDTO.setPageSize(Integer.parseInt((String) oldConcerts.get("page_size")));
                concertsDTO.setPageNumber(Integer.parseInt((String) oldConcerts.get("page_number")));
                concertsDTO.setPageCount(Integer.parseInt((String) oldConcerts.get("page_count")));
                concertsDTO.setConcerts(parseEvents((JSONObject) oldConcerts.get("events")));
            }
        } catch(ParseException e) {
            e.printStackTrace();
        }

        return concertsDTO;
    }

    /**
     * Parse a concert into a concerts DTO.
     *
     * @param concert           The concert to parse.
     * @return                  A concerts DTO.
     * @see                     com.hanze.ticketcenter.artistservice.dto.ConcertsDTO
     */
    public ConcertsDTO parseConcert(String concert) {
        ConcertsDTO concertsDTO = new ConcertsDTO();

        try {
            JSONObject oldConcert = (JSONObject) new JSONParser().parse(concert);

            if(oldConcert.get("status") == null) {
                concertsDTO.setConcerts(parseConcertEvent(oldConcert));
            }
        } catch(ParseException e) {
            e.printStackTrace();
        }

        return concertsDTO;
    }

    /**
     * Parse events into a map.
     *
     * @param events            The events to parse.
     * @return                  Parsed events.
     */
    private Map parseEvents(JSONObject events) {
        Map<String, List> newConcerts = new LinkedHashMap<>();

        if(events != null) {
            Object event = events.get("event");
            List<Map> newConcertsList = new LinkedList<>();

            if(event instanceof JSONObject) {
                JSONObject eventJsonObject = (JSONObject) event;
                newConcertsList.add(parseConcertsEvent(eventJsonObject));
            } else if(event instanceof JSONArray) {
                JSONArray eventJsonArray = (JSONArray) event;

                for(Object eventJsonObject : eventJsonArray) {
                    newConcertsList.add(parseConcertsEvent((JSONObject) eventJsonObject));
                }
            }

            newConcerts.put("concert", newConcertsList);
        }

        return newConcerts;
    }

    /**
     * Parse an event into a map.
     *
     * @param event             The event to parse.
     * @return                  A parsed event.
     */
    private Map parseConcertsEvent(JSONObject event) {
        Map<String, Object> newConcert = new LinkedHashMap<>();

        if(event != null) {
            newConcert.put("id", event.get("id"));
            newConcert.put("title", event.get("title"));
            newConcert.put("description", event.get("description"));
            newConcert.put("performers", parsePerformers((JSONObject) event.get("performers")));
            newConcert.put("country", event.get("country_name"));
            newConcert.put("region", event.get("region_name"));
            newConcert.put("city", event.get("city_name"));
            newConcert.put("start_time", event.get("start_time"));
            newConcert.put("stop_time", event.get("stop_time"));
            newConcert.put("tickets_available", parseTicketsAvailable((String) event.get("longitude")));
            newConcert.put("ticket_price", parseTicketPrice((String) event.get("latitude")));
        }

        return newConcert;
    }

    /**
     * Parse an event into a map.
     *
     * @param event             The event to parse.
     * @return                  A parsed event.
     */
    private Map parseConcertEvent(JSONObject event) {
        Map<String, Object> newConcert = new LinkedHashMap<>();

        if(event != null) {
            newConcert.put("id", event.get("id"));
            newConcert.put("title", event.get("title"));
            newConcert.put("description", event.get("description"));
            newConcert.put("performers", parsePerformers((JSONObject) event.get("performers")));
            newConcert.put("country", event.get("country"));
            newConcert.put("region", event.get("region"));
            newConcert.put("city", event.get("city"));
            newConcert.put("start_time", event.get("start_time"));
            newConcert.put("stop_time", event.get("stop_time"));
            newConcert.put("tickets_available", parseTicketsAvailable((String) event.get("longitude")));
            newConcert.put("ticket_price", parseTicketPrice((String) event.get("latitude")));
        }

        return newConcert;
    }

    /**
     * Parse performers into a map.
     *
     * @param performers        The performers to parse.
     * @return                  Parsed performers.
     */
    private Map parsePerformers(JSONObject performers) {
        Map<String, List> newPerformers = new LinkedHashMap<>();

        if(performers != null) {
            Object performer = performers.get("performer");
            List<Map> netPerformersList = new LinkedList<>();

            if(performer instanceof JSONObject) {
                JSONObject eventJsonObject = (JSONObject) performer;
                netPerformersList.add(parsePerformer(eventJsonObject));
            } else if(performer instanceof JSONArray) {
                JSONArray eventJsonArray = (JSONArray) performer;

                for(Object eventJsonObject : eventJsonArray) {
                    netPerformersList.add(parsePerformer((JSONObject) eventJsonObject));
                }
            }

            newPerformers.put("concert", netPerformersList);
        }

        return newPerformers;
    }

    /**
     * Parse a performer into a map.
     *
     * @param performer         The performer to parse.
     * @return                  A parsed performer.
     */
    private Map parsePerformer(JSONObject performer) {
        Map<String, Object> newPerformer = new LinkedHashMap<>();

        if(performer != null) {
            newPerformer.put("name", performer.get("name"));
        }

        return newPerformer;
    }

    /**
     * Parse tickets available into a integer.
     *
     * @param ticketsAvailable  The tickets available to parse.
     * @return                  The tickets available.
     */
    private Integer parseTicketsAvailable(String ticketsAvailable) {
        String[] split = ticketsAvailable.replace("-", "").split("\\.");
        Integer price = null;

        try {
            if(split.length == 2) {
                price = Integer.parseInt(split[1]) / 5000;
            } else {
                price = Integer.parseInt(split[0]);
            }
        } catch(NumberFormatException e) {
            e.printStackTrace();
        }

        return price;
    }

    /**
     * Parse tickets price into a double.
     *
     * @param ticketsPrice      The tickets price to parse.
     * @return                  The tickets price.
     */
    private Double parseTicketPrice(String ticketsPrice) {
        String[] split = ticketsPrice.replace("-", "").split("\\.");
        Double price = null;

        try {
            if(split.length == 2) {
                price = Double.parseDouble(split[1]) / 20000;

                if (price <= 10) {
                    price += 10;
                }

                DecimalFormat decimalFormat = new DecimalFormat("#.##");
                price = Double.valueOf(decimalFormat.format(price));
            } else {
                price = Double.parseDouble(split[0]);
            }
        } catch(NumberFormatException e) {
            e.printStackTrace();
        }

        return price;
    }
}
