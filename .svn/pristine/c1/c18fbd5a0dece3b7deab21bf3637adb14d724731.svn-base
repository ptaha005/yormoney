package com.codexsoft.yormoney.jsonserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JsonDeserializerDate extends StdDeserializer<Date> {

    private final Logger log = Logger.getLogger(JsonDeserializerDate.class);

    public JsonDeserializerDate(){
        super(Date.class);
    }

    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        String strDate = jsonParser.getText();
        DateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date =  dt.parse(strDate);
        } catch (ParseException e) {
            log.error("Error parse field date");
        }
        return date;
    }
}
