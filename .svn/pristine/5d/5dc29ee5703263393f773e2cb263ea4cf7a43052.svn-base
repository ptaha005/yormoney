package com.codexsoft.yormoney.jsonserializers;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateTypeAdapter implements JsonSerializer<Date> {
    private static final JsonParser parser = new JsonParser();
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
    private TimeZone timeZone;

    public DateTypeAdapter(TimeZone timeZone) {
        if(timeZone != null)
            this.timeZone = timeZone;
        else
            this.timeZone = TimeZone.getDefault();
    }

    @Override
    public JsonElement serialize(Date date, Type dateType, JsonSerializationContext jsonSerializationContext) {
        Calendar localTime = Calendar.getInstance(TimeZone.getDefault());
        Calendar userTime = Calendar.getInstance(timeZone);

        localTime.setTime(date);
        userTime.setTimeInMillis(localTime.getTimeInMillis());

        return new JsonPrimitive(sdf.format(userTime.getTime()));
    }
}