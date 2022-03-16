package com.oracletest.tms.resources;

import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.json.JsonReadContext;
import com.google.inject.servlet.RequestParameters;
import com.oracletest.tms.TMSDBFactory;
import com.oracletest.tms.facade.TaskActionFacade;
import com.oracletest.tms.model.Task;
import com.oracletest.tms.model.TaskAction;
import com.oracletest.tms.model.TaskConstants;
import com.oracletest.tms.model.TaskRequest;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.jetty.util.ajax.JSON;
import org.glassfish.jersey.process.internal.RequestScoped;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Path("/task")
@Produces(MediaType.APPLICATION_JSON)
@Named
@Slf4j
public class TaskResource {
    private final TMSDBFactory dbFactory;
    private final TaskActionFacade taskRepository;

    @Inject
    public TaskResource(TMSDBFactory dbFactory, TaskActionFacade taskRepository) {
        this.dbFactory = dbFactory;
        this.taskRepository = taskRepository;
    }

    @Path("/{id}")
    @GET
    @Timed
    public Task getTaskById(@PathParam("id") Integer id) {
        Optional<Task> task = taskRepository.findById(id);
        return task.isPresent()?task.get():new Task();
    }

    @Path("/create")
    @POST
    @Timed
    @Consumes(MediaType.APPLICATION_JSON)
    public TaskAction createNew(Task task) {
        return taskRepository.persistTaskWithAction(task);
    }

    @Path("/modify")
    @POST
    @Timed
    @Consumes(MediaType.APPLICATION_JSON)
    public TaskAction modifyTask(Task task) {
        task.setStatus(TaskConstants.ACTION.MODIFY.name().toLowerCase(Locale.ROOT));
        return taskRepository.modifyTask(task);
    }

    @Path("/close")
    @POST
    @Timed
    @Consumes(MediaType.APPLICATION_JSON)
    public TaskAction closeTask(Task task) {
        log.info("task received = {}", task);
        task.setStatus(TaskConstants.ACTION.CLOSE.name().toLowerCase(Locale.ROOT));
        return taskRepository.modifyTask(task);
    }

    @Path("/mytasks/{user}")
    @GET
    public List<Task> findMyTasks(@PathParam("user") String user) {
        log.info("user supplied from client = {}", user);
        assert user != null;
        return taskRepository.findTaskByUser(user);
    }

}

