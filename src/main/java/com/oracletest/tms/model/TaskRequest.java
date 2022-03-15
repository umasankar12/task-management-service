package com.oracletest.tms.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TaskRequest {

    String user;

    public TaskRequest(){}

    public TaskRequest(String user) {
        this.user = user;
    }

    @JsonProperty
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
