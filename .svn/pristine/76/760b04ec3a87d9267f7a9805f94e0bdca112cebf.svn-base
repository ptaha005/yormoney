package com.codexsoft.yormoney.views;

import com.codexsoft.yormoney.domain.DomainObject;
import com.codexsoft.yormoney.jsonserializers.JsonSerializer;
import com.codexsoft.yormoney.util.datatables.DatatablesStructure;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;

public class JsonView implements View {
    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    public String getContentType() {
        return "application/json";
    }

    @Override
    public void render(Map<String, ?> stringMap, HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        if(stringMap != null && stringMap.get("data") != null){
            out.print(JsonSerializer.serialize((DatatablesStructure<DomainObject>) (stringMap.get("data"))));
        } else {
            out.print("{result : ok}");
        }

        out.flush();
    }

}
