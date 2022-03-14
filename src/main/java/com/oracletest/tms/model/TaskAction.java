package com.oracletest.tms.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jdbi.v3.core.mapper.reflect.ColumnName;

import java.time.LocalDateTime;

public class TaskAction {

    @ColumnName("id")
    int id;
    @ColumnName("task_id")
    int taskId;
    @ColumnName("updated_by")
    String updateBy;
    @ColumnName("update_time")
    LocalDateTime updateTime;
    @ColumnName("action")
    String action;

    @ColumnName("prev_state")
    String prevState;

    public TaskAction() {
    }

    public TaskAction(int id, int taskId, String updateBy, LocalDateTime updateTime, String action) {
        this.id = id;
        this.taskId = taskId;
        this.updateBy = updateBy;
        this.updateTime = updateTime;
        this.action = action;
    }

    @JsonProperty
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @JsonProperty
    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    @JsonProperty
    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    @JsonProperty
    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    @JsonProperty
    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getPrevState() {
        return prevState;
    }

    public void setPrevState(String prevState) {
        this.prevState = prevState;
    }
}
