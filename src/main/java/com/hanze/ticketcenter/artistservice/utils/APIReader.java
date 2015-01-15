package com.hanze.ticketcenter.artistservice.utils;

import org.apache.commons.io.IOUtils;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

public class APIReader {
    private String url;
    private String format;
    private String string;

    public APIReader(String url, String format) {
        this.url = url;
        this.format = format;
        this.string = "";
    }

    public void read() throws IOException {
        InputStream inputStream = new URL(url).openStream();

        try {
            this.string = IOUtils.toString(inputStream);
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(inputStream);
        }
    }

    // TODO: Removes only upper layered keys, not nested
    public void removeAttributes(List remove) {
        if(this.format.equals("xml")) {
            // TODO: Convert XML to String
        } else if(this.format.equals("json")) {
            JSONObject jsonObject = (JSONObject) JSONValue.parse(this.string);
            Iterator iterator = remove.iterator();

            while(iterator.hasNext()) {
                String key = (String) iterator.next();
                JSONParser parser = new JSONParser();
                KeyFinder finder = new KeyFinder();
                finder.setMatchKey(key);

                try {
                    while(!finder.isEnd()) {
                        parser.parse(this.string, finder, true);

                        if(finder.isFound()) {
                            finder.setFound(false);
                            jsonObject.remove(key);
                        }
                    }
                } catch(ParseException e) {
                    e.printStackTrace();
                }
            }

            this.string = JSONValue.toJSONString(jsonObject);
        }
    }

    public String getString() {
        return this.string;
    }
}
