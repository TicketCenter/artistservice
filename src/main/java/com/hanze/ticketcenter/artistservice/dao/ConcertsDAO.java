package com.hanze.ticketcenter.artistservice.dao;

import com.hanze.ticketcenter.artistservice.dao.interfaces.ConcertsDAOInterface;
import com.hanze.ticketcenter.artistservice.resources.EventfulAPI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConcertsDAO extends EventfulAPI implements ConcertsDAOInterface {
    @Override
    public String getConcerts(String location, String pageSize, String pageNumber) {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("category", "music");
        parameters.put("location", location);
        parameters.put("page_size", pageSize);
        parameters.put("page_number", pageNumber);

        List<String> attributes = new ArrayList<>();
        attributes.add("total_items, page_number, page_size, page_count, search_time");
        attributes.add("events/event/id, title, description, country_name, olson_path, region_name, city_name, postal_code, venue_name, start_time, stop_time, created, modified");

        return this.read("events", "search", parameters, attributes);
    }

    @Override
    public String getConcert(String id) {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("id", id);

        List<String> attributes = new ArrayList<>();
        attributes.add("id, title, description, country, olson_path, region, city, postal_code, venue_name, start_time, stop_time, created, modified");
        attributes.add("performers/performer/name, short_bio");
        attributes.add("images/image/id, url, width, height");
        attributes.add("tags/tag/id, title");

        return this.read("events", "get", parameters, attributes);
    }
}
