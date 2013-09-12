package com.codexsoft.yormoney.util.datatables;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ParamBuilder {

    private Map<String, Object> equalParams;
    private Map<String, Object> notEqualParams;
    private Map<String, Object> notNullParam;
    private Map<String, Object> inParam;
    private Map<String, Object> aliasParams;
    private Map<String, Object> isNullParam;
    private Map<String, Object> params;
    private Map<String, Object> order;
    private Map<String, Object> greatThan;
    private Map<String, Object>  lessThan;
    private Map<String, Object>  like;



    private ParamBuilder() {
        params = new HashMap<String, Object>();
        aliasParams = new HashMap<String, Object>();
        equalParams = new HashMap<String, Object>();
        notEqualParams = new HashMap<String, Object>();
        notNullParam = new HashMap<String, Object>();
        isNullParam = new HashMap<String, Object>();
        inParam = new HashMap<String, Object>();
        order = new HashMap<String, Object>();
        greatThan = new HashMap<String, Object>();
        lessThan = new HashMap<String, Object>();
        like = new HashMap<String, Object>();
    }

    public static ParamBuilder getBuilder(){
        return new ParamBuilder();
    }

    public ParamBuilder equal(String key, Object value){
        equalParams.put(key, value);
        return this;
    }

    public ParamBuilder notEqual(String key, Object value){
        notEqualParams.put(key, value);
        return this;
    }

    public ParamBuilder notNull(String key){
        notNullParam.put(key, null);
        return this;
    }

    public ParamBuilder alias(String key, Object value){
        aliasParams.put(key, value);
        return this;
    }

    public ParamBuilder isNull(String key){
        isNullParam.put(key, null);
        return this;
    }

    public ParamBuilder in(String key, Collection value){
        inParam.put(key, value);
        return this;
    }

    public ParamBuilder order(String key, Object value){
        order.put(key, value);
        return this;
    }

    public ParamBuilder greatThan(String key, Object value) {
        greatThan.put(key, value);
        return this;
    }

    public ParamBuilder lessThan(String key, Object value){
        lessThan.put(key, value);
        return this;
    }

    public ParamBuilder like(String key, Object value){
        like.put(key, value);
        return this;
    }

    public Map<String, Object> getParams(){
        params.put("equalParams",equalParams);
        params.put("aliasParams" , aliasParams);
        params.put("notEqualParams",notEqualParams);
        params.put("notNullParam",notNullParam);
        params.put("isNullParam",isNullParam);
        params.put("inParam",inParam);
        params.put("orderParam",order);
        params.put("greatThanParams", greatThan);
        params.put("lessThan", lessThan);
        params.put("like", like);
        return this.params;
    }
}
