package com.oracletest.tms.resources;

import com.codahale.metrics.annotation.Timed;
import com.oracletest.tms.model.Task;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicLong;
import java.util.Optional;

@Path("/task")
@Produces(MediaType.APPLICATION_JSON)
public class TaskResource {
    private final String template;
    private final String defaultName;
    private final AtomicLong counter;

    public TaskResource(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

    @Path("{id}")
    @GET
    @Timed
    public Task getTaskById(@PathParam("id") Optional<Integer> id) {
        return new Task(
            1, "short desc", "long desc", LocalDate.now(), LocalDate.now(),
            "SomeUser", "OPEN"
        );
    }
}

