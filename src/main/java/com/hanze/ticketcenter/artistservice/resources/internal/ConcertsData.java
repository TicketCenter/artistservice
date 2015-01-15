package com.hanze.ticketcenter.artistservice.resources.internal;

import com.hanze.ticketcenter.artistservice.resources.external.EventfulAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

abstract public class ConcertsData extends EventfulAPI {
    public String concertsSource(Map parameters) {
        List<String> remove = new ArrayList<>();
            remove.add("last_item");
            // remove.add("total_items");
            remove.add("first_item");
            // remove.add("page_number");
            // remove.add("page_size");
            remove.add("page_items");
            // remove.add("search_time");
            // remove.add("page_count");
            // remove.add("events");
                // remove.add("event");
                    remove.add("watching_count");
                    // remove.add("olson_path");
                    remove.add("calendar_count");
                    remove.add("comment_count");
                    // remove.add("region_abbr");
                    // remove.add("postal_code");
                    remove.add("going_count");
                    remove.add("all_day");
                    remove.add("latitude");
                    remove.add("groups");
                    remove.add("url");
                    // remove.add("id");
                    remove.add("privacy");
                    // remove.add("city_name");
                    remove.add("link_count");
                    remove.add("longitude");
                    // remove.add("country_name");
                    // remove.add("country_abbr");
                    // remove.add("region_name");
                    // remove.add("start_time");
                    remove.add("tz_id");
                    // remove.add("description");
                    // remove.add("modified");
                    // remove.add("venue_display");
                    // remove.add("tz_country");
                    // remove.add("performers");
                        // remove.add("performer");
                            remove.add("creator");
                            remove.add("linker");
                            // remove.add("name");
                            remove.add("url");
                            remove.add("id");
                            remove.add("short_bio");
                    // remove.add("title");
                    remove.add("venue_address");
                    remove.add("geocode_type");
                    remove.add("tz_olson_path");
                    remove.add("recur_string");
                    remove.add("calendars");
                    remove.add("owner");
                    remove.add("going");
                    // remove.add("country_abbr2");
                    // remove.add("image");
                        // remove.add("small");
                            // remove.add("width");
                            // remove.add("url");
                            // remove.add("height");
                        // remove.add("width");
                        // remove.add("caption");
                        // remove.add("medium");
                            // remove.add("width");
                            // remove.add("url");
                            // remove.add("height");
                        // remove.add("url");
                        // remove.add("thumb");
                            // remove.add("width");
                            // remove.add("url");
                            // remove.add("height");
                        // remove.add("height");
                    // remove.add("created");
                    remove.add("venue_id");
                    remove.add("tz_city");
                    remove.add("stop_time");
                    // remove.add("venue_name");
                    remove.add("venue_url");

        return this.read("events", "search", parameters, remove);
    }

    public String concertSource(Map parameters) {
        List<String> remove = new ArrayList<>();
            remove.add("withdrawn");
            remove.add("children");
            // TODO remove.add all important stuff

        return this.read("events", "get", parameters, remove);
    }
}
