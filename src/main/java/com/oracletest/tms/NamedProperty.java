package com.oracletest.tms;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class NamedProperty{
    private final String id;
    private final Object value;
    private final Class<?> clazz;

    @JsonCreator
    public NamedProperty(@JsonProperty("id") String id, @JsonProperty("value") Object value, @JsonProperty("clazz") Class clazz) {
        this.id = id;
        this.value = value;
        this.clazz = clazz;
    }

    public String getId() {
        return id;
    }

    public Object getValue() {
        return value;
    }

    public Class getClazz() {
        return clazz;
    }
}