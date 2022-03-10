package com.oracletest.tms.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Item {

    final long id;

    final String content;

    public Item(long id, String content) {
        this.id = id;
        this.content = content;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getContent() {
        return content;
    }

}
