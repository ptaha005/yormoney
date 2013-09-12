package com.codexsoft.yormoney.domain;

import com.codexsoft.yormoney.jsonserializers.JsonDeserializerDate;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@MappedSuperclass

public abstract class DomainObject implements Serializable, Cloneable  {

    transient public static final String[] colsPosition = {"id" };

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @org.hibernate.annotations.AccessType("property")
    private Long id;

    private transient Map<String, Object> jsonValues = new HashMap<String, Object>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Map<String, Object> getJsonValues() {
        return jsonValues;
    }

    public void setJsonValues(Map<String, Object> jsonValues) {
        this.jsonValues = jsonValues;
    }
}
