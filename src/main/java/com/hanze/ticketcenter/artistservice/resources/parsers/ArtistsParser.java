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

/**
 * The artists parser.
 *
 * @author      Nils Berlijn
 * @version     1.0
 * @since       1.0
 */
public class ArtistsParser {
    /**
     * Parse artists into an artists DTO.
     *
     * @param artists           The artists to parse.
     * @return                  An artists DTO.
     * @see                     com.hanze.ticketcenter.artistservice.dto.ArtistsDTO
     */
    public ArtistsDTO parseArtists(String artists) {
        ArtistsDTO artistsDTO = new ArtistsDTO();

        try {
            JSONObject oldArtists = (JSONObject) new JSONParser().parse(artists);
            JSONObject results = (JSONObject) oldArtists.get("results");
            JSONObject query = (JSONObject) results.get("opensearch:Query");

            if (!results.get("opensearch:totalResults").equals("0")) {
                artistsDTO.setTotalItems(Integer.parseInt((String) results.get("opensearch:totalResults")));
                artistsDTO.setPageSize(Integer.parseInt((String) results.get("opensearch:itemsPerPage")));
                artistsDTO.setPageNumber(Integer.parseInt((String) query.get("startPage")));
                artistsDTO.setPageCount(parsePageCount((String) results.get("opensearch:totalResults"), (String) results.get("opensearch:itemsPerPage")));
                artistsDTO.setArtists(parseArtistMatches((JSONObject) results.get("artistmatches")));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return artistsDTO;
    }

    /**
     * Parse an artist into an artists DTO.
     *
     * @param artist            The artist to parse.
     * @return                  An artists DTO.
     * @see                     com.hanze.ticketcenter.artistservice.dto.ArtistsDTO
     */
    public ArtistsDTO parseArtist(String artist) {
        ArtistsDTO artistsDTO = new ArtistsDTO();

        try {
            JSONObject oldArtist = (JSONObject) new JSONParser().parse(artist);

            if (oldArtist.get("error") == null) {
                artistsDTO.setArtists(parseArtistArtist((JSONObject) oldArtist.get("artist")));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return artistsDTO;
    }

    /**
     * Parse artists into a map.
     *
     * @param artists           The artists to parse.
     * @return                  Parsed artists.
     */
    private Map<String, List> parseArtistMatches(JSONObject artists) {
        Map<String, List> newArtists = new LinkedHashMap<>();

        if (artists != null) {
            Object artist = artists.get("artist");
            List<Map> newArtistsList = new LinkedList<>();

            if (artist instanceof JSONObject) {
                JSONObject artistJsonObject = (JSONObject) artist;
                newArtistsList.add(parseArtistsArtist(artistJsonObject));
            } else if (artist instanceof JSONArray) {
                JSONArray artistJsonArray = (JSONArray) artist;

                for (Object eventJsonObject : artistJsonArray) {
                    newArtistsList.add(parseArtistsArtist((JSONObject) eventJsonObject));
                }
            }

            newArtists.put("artist", newArtistsList);
        } else {
            newArtists = null;
        }

        return newArtists;
    }

    /**
     * Parse an artist into a map.
     *
     * @param artist            The artist to parse.
     * @return                  A parsed artist.
     */
    private Map<String, Object> parseArtistsArtist(JSONObject artist) {
        Map<String, Object> newArtist = new LinkedHashMap<>();

        if (artist != null) {
            newArtist.put("name", artist.get("name"));
            newArtist.put("image", parseImage((JSONObject) ((JSONArray) artist.get("image")).get(1)));
        } else {
            newArtist = null;
        }

        return newArtist;
    }

    /**
     * Parse an artist into a map.
     *
     * @param artist            The artist to parse.
     * @return                  A parsed artist.
     */
    private Map<String, Object> parseArtistArtist(JSONObject artist) {
        Map<String, Object> newArtist = new LinkedHashMap<>();

        if (artist != null) {
            JSONObject bio = (JSONObject) artist.get("bio");
            newArtist.put("name", artist.get("name"));
            newArtist.put("biography", bio.get("content"));
            newArtist.put("birth_year", bio.get("yearformed"));
            newArtist.put("image", parseImage((JSONObject) ((JSONArray) artist.get("image")).get(1)));
        } else {
            newArtist = null;
        }

        return newArtist;
    }

    /**
     * Parse an image into a map.
     *
     * @param image             The image to parse.
     * @return                  A parsed image.
     */
    private Map<String, Object> parseImage(JSONObject image) {
        Map<String, Object> newImage = new LinkedHashMap<>();

        if (image != null) {
            newImage.put("url", image.get("#text"));
        } else {
            newImage = null;
        }

        return newImage;
    }

    /**
     * Parse total items and page number into a integer as page count.
     *
     * @param totalItems        The tickets available to parse.
     * @param pageNumber        The tickets available to parse.
     * @return                  The page count.
     */
    private Integer parsePageCount(String totalItems, String pageNumber) {
        return Integer.parseInt(totalItems) / Integer.parseInt(pageNumber);
    }
}
