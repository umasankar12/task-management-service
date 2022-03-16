package com.oracletest.tms.facade;

import com.oracletest.tms.model.Task;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.config.RegisterFieldMapper;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.util.List;
import java.util.Optional;

public interface TaskDAO {

    @SqlQuery("INSERT INTO Task(short_desc, long_desc, create_date, target_date, created_by, status) values \n" +
        "(:shortDesc, :longDesc, current_timestamp, :targetDate, :createdBy, :status) returning *")
    @RegisterFieldMapper(Task.class)
    public Task create(@BindBean Task task);

    @SqlQuery("update task set short_desc=:shortDesc, long_desc=:longDesc, status=:status where id=:id returning *")
    @RegisterFieldMapper(Task.class)
    public Task update(@BindBean Task task);

    @SqlQuery("Select * from Task where created_by=?")
    @RegisterBeanMapper(Task.class)
    public List<Task> findByUser(String user);

    @SqlQuery("Select * from Task where id=:id")
    @RegisterBeanMapper(Task.class)
    public Task findById(@BindBean Task task);

    @SqlQuery("Select * from Task where id=?")
    @RegisterBeanMapper(Task.class)
    public Optional<Task> findById(Integer id);

}
