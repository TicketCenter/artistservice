package com.hanze.ticketcenter.artistservice.utils;

import org.apache.commons.io.IOUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

public class APIReader {
    private String url;
    private String string;

    public APIReader(String url) {
        this.url = url;
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

    public void getAttributes(List attributes) {
        JSONObject jsonObject = (JSONObject) JSONValue.parse(this.string);
        JSONObject newJsonObject = new JSONObject();
        Iterator iterator = attributes.iterator();

        while(iterator.hasNext()) {
            String[] attributesSplit = iterator.next().toString().split("/");

            if(attributesSplit.length == 1) {
                String[] keysSplit = attributesSplit[0].split(", ");

                for(int i = 0; i < keysSplit.length; i++) {
                    newJsonObject.put(keysSplit[i], jsonObject.get(keysSplit[i]));
                }
            } else if(attributesSplit.length == 3) {
                JSONObject oneDeepOld = (JSONObject) jsonObject.get(attributesSplit[0]);
                String[] keysSplit = attributesSplit[2].split(", ");

                if(oneDeepOld.get(attributesSplit[1]) instanceof JSONObject) {
                    JSONObject threeDeepOld = (JSONObject) oneDeepOld.get(attributesSplit[1]);
                    JSONObject threeDeepNew = new JSONObject();

                    for(int i = 0; i < keysSplit.length; i++) {
                        threeDeepNew.put(keysSplit[i], threeDeepOld.get(keysSplit[i]));
                    }

                    JSONObject twoDeepNew = new JSONObject();
                    twoDeepNew.put(attributesSplit[1], threeDeepNew);
                    newJsonObject.put(attributesSplit[0], twoDeepNew);

                } else if(oneDeepOld.get(attributesSplit[1]) instanceof JSONArray) {
                    JSONArray threeDeepOld = (JSONArray) oneDeepOld.get(attributesSplit[1]);
                    JSONArray fourDeepNew = new JSONArray();

                    for(int i = 0; i < threeDeepOld.size(); i++) {
                        JSONObject threeDeepOldOne = (JSONObject) threeDeepOld.get(i);
                        JSONObject threeDeepNew = new JSONObject();

                        for(int j = 0; j < keysSplit.length; j++) {
                            threeDeepNew.put(keysSplit[j], threeDeepOldOne.get(keysSplit[j]));
                        }

                        fourDeepNew.add(threeDeepNew);
                    }

                    JSONObject twoDeepNew = new JSONObject();
                    twoDeepNew.put(attributesSplit[1], fourDeepNew);
                    newJsonObject.put(attributesSplit[0], twoDeepNew);
                }
            }
        }

        this.string = JSONValue.toJSONString(newJsonObject);
    }

    public String getString() {
        return this.string;
    }
}
