package com.codexsoft.yormoney.views;

import com.codexsoft.yormoney.jsonserializers.SimpleJsonSerializer;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;

/**
 * Created by Roman Tsuranov
 */
public class SimpleView implements View {
    @Override
    public String getContentType() {
        return "application/json";
    }

    @Override
    public void render(Map<String, ?> stringMap, HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print(SimpleJsonSerializer.serializeMap((Map<String, String>) stringMap));
        out.flush();
    }
}
