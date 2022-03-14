package com.oracletest.tms.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;
import org.jdbi.v3.core.mapper.reflect.ColumnName;

import java.time.LocalDate;

@ToString
public class Task {

    @ColumnName("id")
    int id;

    @ColumnName("short_desc")
    String shortDesc;

    @ColumnName("long_desc")
    String longDesc;

    @ColumnName("create_date")
    LocalDate createDate;

    @ColumnName("target_date")
    LocalDate targetDate;

    @ColumnName("created_by")
    String createdBy;

    @ColumnName("status")
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

    public Task() {
    }

    @JsonProperty
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @JsonProperty
    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    @JsonProperty
    public String getLongDesc() {
        return longDesc;
    }

    public void setLongDesc(String longDesc) {
        this.longDesc = longDesc;
    }

    @JsonProperty
    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    @JsonProperty
    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    @JsonProperty
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @JsonProperty
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
