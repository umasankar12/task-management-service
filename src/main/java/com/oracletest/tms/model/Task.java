package com.oracletest.tms.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;

public class Task {

    int id;

    String shortDesc;

    String longDesc;

    LocalDate createDate;

    LocalDate targetDate;

    String createdBy;

    String status;

    public Task(int id, String shortDesc, String longDesc, LocalDate createDate, LocalDate targetDate, String createdBy, String status) {
        this.id = id;
        this.shortDesc = shortDesc;
        this.longDesc = longDesc;
        this.createDate = createDate;
        this.targetDate = targetDate;
        this.createdBy = createdBy;
        this.status = status;
    }

    @JsonProperty
    public int getId() {
        return id;
    }

    public Task setId(int id) {
        this.id = id;
        return this;
    }

    @JsonProperty
    public String getShortDesc() {
        return shortDesc;
    }

    public Task setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
        return this;
    }

    @JsonProperty
    public String getLongDesc() {
        return longDesc;
    }

    public Task setLongDesc(String longDesc) {
        this.longDesc = longDesc;
        return this;
    }

    @JsonProperty
    public LocalDate getCreateDate() {
        return createDate;
    }

    public Task setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
        return this;
    }

    @JsonProperty
    public LocalDate getTargetDate() {
        return targetDate;
    }

    public Task setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
        return this;
    }

    @JsonProperty
    public String getCreatedBy() {
        return createdBy;
    }

    public Task setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    @JsonProperty
    public String getStatus() {
        return status;
    }

    public Task setStatus(String status) {
        this.status = status;
        return this;
    }
}
