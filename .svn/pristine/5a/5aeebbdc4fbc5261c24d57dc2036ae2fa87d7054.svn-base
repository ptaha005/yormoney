package com.codexsoft.yormoney.jsonserializers;

import com.google.gson.*;

import java.util.Map;

/**
 * User: Roman Tsuranov
 **/
public class SimpleJsonSerializer {
    public static JsonElement serializeMap(Map<String, String> map) {
        JsonObject element = new JsonObject();
        for(String key : map.keySet()){
            element.addProperty(key, map.get(key));
        }
        return element;
    }

    public static JsonElement serializeSingleValue(String property, String value) {
        JsonObject element = new JsonObject();
        element.addProperty(property, value);
        return element;
    }
}
