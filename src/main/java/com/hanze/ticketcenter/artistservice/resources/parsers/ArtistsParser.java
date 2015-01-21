package com.hanze.ticketcenter.artistservice.resources.parsers;

import com.hanze.ticketcenter.artistservice.dto.ArtistsDTO;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ArtistsParser {
    public ArtistsDTO parseArtists(String artists) {
        ArtistsDTO artistsDTO = new ArtistsDTO();

        try {
            JSONObject oldArtists = (JSONObject) new JSONParser().parse(artists);
            JSONObject results = (JSONObject) oldArtists.get("results");
            JSONObject query = (JSONObject) results.get("opensearch:Query");

            if(!results.get("opensearch:totalResults").equals("0")) {
                artistsDTO.setTotalItems(Integer.parseInt((String) results.get("opensearch:totalResults")));
                artistsDTO.setPageSize(Integer.parseInt((String) results.get("opensearch:itemsPerPage")));
                artistsDTO.setPageNumber(Integer.parseInt((String) query.get("startPage")));
                artistsDTO.setPageCount(parsePageCount((String) results.get("opensearch:totalResults"), (String) results.get("opensearch:itemsPerPage")));
                artistsDTO.setArtists(parseArtistMatches((JSONObject) results.get("artistmatches")));
            }
        } catch(ParseException e) {
            e.printStackTrace();
        }

        return artistsDTO;
    }

    public ArtistsDTO parseArtist(String artist) {
        ArtistsDTO artistsDTO = new ArtistsDTO();

        try {
            JSONObject oldArtist = (JSONObject) new JSONParser().parse(artist);

            if(oldArtist.get("error") == null) {
                artistsDTO.setArtists(parseArtistArtist((JSONObject) oldArtist.get("artist")));
            }
        } catch(ParseException e) {
            e.printStackTrace();
        }

        return artistsDTO;
    }

    private Map parseArtistMatches(JSONObject oldArtists) {
        Map<String, List> newArtists = new LinkedHashMap<>();

        if(oldArtists != null) {
            Object artist = oldArtists.get("artist");
            List<Map> newArtistsList = new LinkedList<>();

            if(artist instanceof JSONObject) {
                JSONObject artistJsonObject = (JSONObject) artist;
                newArtistsList.add(parseArtistsArtist(artistJsonObject));
            } else if(artist instanceof JSONArray) {
                JSONArray artistJsonArray = (JSONArray) artist;

                for(Object eventJsonObject : artistJsonArray) {
                    newArtistsList.add(parseArtistsArtist((JSONObject) eventJsonObject));
                }
            }

            newArtists.put("artist", newArtistsList);
        }

        return newArtists;
    }

    private Map parseArtistsArtist(JSONObject oldArtist) {
        Map<String, Object> newArtist = new LinkedHashMap<>();

        if(oldArtist != null) {
            newArtist.put("name", oldArtist.get("name"));
        }

        return newArtist;
    }

    private Map parseArtistArtist(JSONObject oldArtist) {
        Map<String, Object> newArtist = new LinkedHashMap<>();

        if(oldArtist != null) {
            JSONObject bio = (JSONObject) oldArtist.get("bio");

            newArtist.put("name", oldArtist.get("name"));
            newArtist.put("biography", bio.get("content"));
            newArtist.put("birth_year", bio.get("yearformed"));
        }

        return newArtist;
    }

    private Integer parsePageCount(String totalItems, String pageNumber) {
        return Integer.parseInt(totalItems) / Integer.parseInt(pageNumber);
    }
}
