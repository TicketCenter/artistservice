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
        Map<String, String> params = new HashMap<>();
            params.put("category", "music");
            params.put("location", location);
            params.put("page_size", pageSize);
            params.put("page_number", pageNumber);

        List<String> remove = new ArrayList<>();
            remove.add("page_items");
            remove.add("first_item");
            remove.add("last_item");

        return this.read("events", "search", params, remove);
    }

    @Override
    public String getConcert(String id) {
        Map<String, String> params = new HashMap<>();
            params.put("category", "music");
            params.put("id", id);

        List<String> remove = new ArrayList<>();
            remove.add("withdrawn");
            remove.add("children");
            remove.add("comments");
            remove.add("all_day");
            remove.add("groups");
            remove.add("url");
            remove.add("privacy");
            remove.add("links");
            remove.add("withdrawn_note");
            remove.add("tz_id");
            remove.add("properties");
            remove.add("recurrence");
            remove.add("venue_display");
            remove.add("tz_country");
            remove.add("parents");
            remove.add("geocode_type");
            remove.add("tz_olson_path");
            remove.add("free");
            remove.add("trackbacks");
            remove.add("calendars");
            remove.add("owner");
            remove.add("categories");
            remove.add("tags");
            remove.add("tz_city");
            remove.add("stop_time");

        return this.read("events", "get", params, remove);
    }
}
