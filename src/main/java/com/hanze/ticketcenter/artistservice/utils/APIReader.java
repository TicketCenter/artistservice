package com.hanze.ticketcenter.artistservice.utils;

import org.apache.commons.io.IOUtils;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

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

        try {
            this.read();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    private void read() throws IOException {
        InputStream inputStream = new URL(url).openStream();

        try {
            this.string = IOUtils.toString(inputStream);
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(inputStream);
        }
    }

    public void removeAttributes(List remove) {
        if(this.format.equals("json")) {
            JSONObject jsonObject = (JSONObject) JSONValue.parse(this.string);
            Iterator iterator = remove.iterator();

            while(iterator.hasNext()) {
                jsonObject.remove(iterator.next());
            }

            this.string = jsonObject.toString();
        } else if(this.format.equals("xml")) {
            // TODO
        }
    }

    public String getString() {
        return this.string;
    }
}
