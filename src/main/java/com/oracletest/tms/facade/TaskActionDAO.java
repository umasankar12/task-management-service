package com.oracletest.tms.facade;

import com.oracletest.tms.model.TaskAction;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

public interface TaskActionDAO {

    @SqlQuery("insert into task_action(task_id, update_by, update_time, action, prev_state)" +
        " values (:taskId, :updateBy, :updateTime, :action, :prevState) returning *")
    @RegisterBeanMapper(TaskAction.class)
    public TaskAction create(@BindBean TaskAction action);

}
