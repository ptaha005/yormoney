package com.codexsoft.yormoney.jsonserializers;

import com.codexsoft.yormoney.util.datatables.DatatablesStructure;
import com.google.gson.*;
import java.util.Date;

public class JsonSerializer {

    public static JsonElement serialize(DatatablesStructure data) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("sEcho", data.getEcho());
        jsonObject.addProperty("iTotalRecords", data.getTotalRecords());
        jsonObject.addProperty("iTotalDisplayRecords", data.getTotalDisplayRecords());
        GsonBuilder gsonbuilder = new GsonBuilder();
        gsonbuilder.setExclusionStrategies(new GsonExclusionStrategy(null));

        gsonbuilder.registerTypeHierarchyAdapter(Enum.class, new EnumTypeAdapter());
        gsonbuilder.registerTypeAdapter(Date.class, new DateTypeAdapter(data.getTimeZone()));

        Gson gson = gsonbuilder.serializeNulls().setDateFormat("dd MMM yyyy").create();

        jsonObject.add("aaData", gson.toJsonTree(data.getData()));
        return jsonObject;
    }

}
