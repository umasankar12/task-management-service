package com.oracletest.tms.resources;

import com.codahale.metrics.annotation.Timed;
import com.oracletest.tms.TMSDBFactory;
import com.oracletest.tms.model.Task;
import org.jdbi.v3.core.Jdbi;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.time.LocalDate;
import java.util.Optional;

@Path("/task")
@Produces(MediaType.APPLICATION_JSON)
@Named
public class TaskResource {
    private final TMSDBFactory dbFactory;

    @Inject
    public TaskResource(TMSDBFactory dbFactory) {
        this.dbFactory = dbFactory;
    }

    @Path("/{id}")
    @GET
    @Timed
    public Task getTaskById(@PathParam("id") Optional<Integer> id) {
        return new Task(
            1, "short desc", "long desc", LocalDate.now(), LocalDate.now(),
            "SomeUser", "OPEN"
        );
    }

    @Path("create")
    @POST
    @Timed
    @Consumes(MediaType.APPLICATION_JSON)
    public Task createNew(Task task) {
        String insertSql = "INSERT INTO TASK(short_desc, long_desc, create_date, target_date, created_by, status) values (" +
            "'First one', 'First One long', current_date, current_date, 'test', 'open')";
        dbFactory.getJdbi().withHandle(h -> h.execute(insertSql));
        return task;
    }
}

