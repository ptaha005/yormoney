package com.codexsoft.yormoney.jsonserializers;

import com.google.common.collect.MapMaker;
import com.google.gson.*;
import com.google.gson.JsonSerializer;
import com.google.common.base.Function;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Map;

public class EnumTypeAdapter<T extends Enum<T>> implements JsonSerializer<T> {
    @Override
    public JsonElement serialize(T src, Type typeOfSrc, JsonSerializationContext jsonSerializationContext) {
        try {
            Method getName = src.getClass().getMethod("getName");
            return new JsonPrimitive(getName.invoke(src).toString());
        } catch (Exception e) {
            return null;
        }
    }
}