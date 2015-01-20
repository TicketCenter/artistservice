package com.hanze.ticketcenter.artistservice.resources.parsers;

import com.hanze.ticketcenter.artistservice.dto.ConcertsDTO;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.text.DecimalFormat;
import java.util.*;

public class ConcertsParser {
    public ConcertsDTO parseConcerts(String concerts) {
        ConcertsDTO concertsDTO = new ConcertsDTO();

        try {
            JSONObject oldConcerts = (JSONObject) new JSONParser().parse(concerts);

            if(oldConcerts.get("total_items") != null) {
                concertsDTO.setTotalItems(Integer.parseInt((String) oldConcerts.get("total_items")));
                concertsDTO.setPageSize(Integer.parseInt((String) oldConcerts.get("page_size")));
                concertsDTO.setPageNumber(Integer.parseInt((String) oldConcerts.get("page_number")));
                concertsDTO.setPageCount(Integer.parseInt((String) oldConcerts.get("page_count")));
                concertsDTO.setSearchTime(Double.parseDouble((String) oldConcerts.get("search_time")));
                concertsDTO.setConcerts(parseEvents((JSONObject) oldConcerts.get("events")));
            }
        } catch(ParseException e) {
            e.printStackTrace();
        }

        return concertsDTO;
    }

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

    private Map parseEvents(JSONObject oldEvents) {
        Map<String, List> newConcerts = new LinkedHashMap<>();

        if(oldEvents != null) {
            Object event = oldEvents.get("event");
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

    private Map parseConcertsEvent(JSONObject oldConcert) {
        Map<String, Object> newConcert = new LinkedHashMap<>();

        if(oldConcert != null) {
            newConcert.put("id", oldConcert.get("id"));
            newConcert.put("title", oldConcert.get("title"));
            newConcert.put("description", oldConcert.get("description"));
            newConcert.put("performers", parsePerformers((JSONObject) oldConcert.get("performers")));
            newConcert.put("country", oldConcert.get("country_name"));
            newConcert.put("region", oldConcert.get("region_name"));
            newConcert.put("city", oldConcert.get("city_name"));
            newConcert.put("start_time", oldConcert.get("start_time"));
            newConcert.put("stop_time", oldConcert.get("stop_time"));
            newConcert.put("tickets_available", parseTicketsAvailable((String) oldConcert.get("longitude")));
            newConcert.put("price", parsePrice((String) oldConcert.get("latitude")));
        }

        return newConcert;
    }

    private Map parseConcertEvent(JSONObject oldConcert) {
        Map<String, Object> newConcert = new LinkedHashMap<>();

        if(oldConcert != null) {
            newConcert.put("id", oldConcert.get("id"));
            newConcert.put("title", oldConcert.get("title"));
            newConcert.put("description", oldConcert.get("description"));
            newConcert.put("performers", parsePerformers((JSONObject) oldConcert.get("performers")));
            newConcert.put("country", oldConcert.get("country"));
            newConcert.put("region", oldConcert.get("region"));
            newConcert.put("city", oldConcert.get("city"));
            newConcert.put("start_time", oldConcert.get("start_time"));
            newConcert.put("stop_time", oldConcert.get("stop_time"));
            newConcert.put("tickets_available", parseTicketsAvailable((String) oldConcert.get("longitude")));
            newConcert.put("price", parsePrice((String) oldConcert.get("latitude")));
        }

        return newConcert;
    }

    private Map parsePerformers(JSONObject oldPerformers) {
        Map<String, List> newPerformers = new LinkedHashMap<>();

        if(oldPerformers != null) {
            Object performer = oldPerformers.get("performer");
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

    private Map parsePerformer(JSONObject oldPerformer) {
        Map<String, Object> newPerformer = new LinkedHashMap<>();

        if(oldPerformer != null) {
            newPerformer.put("name", oldPerformer.get("name"));
            newPerformer.put("short_bio", oldPerformer.get("short_bio"));
        }

        return newPerformer;
    }

    private Integer parseTicketsAvailable(String longitude) {
        String[] split = longitude.replace("-", "").split("\\.");
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

    private Double parsePrice(String latitude) {
        String[] split = latitude.replace("-", "").split("\\.");
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
