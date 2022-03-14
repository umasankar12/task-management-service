package com.oracletest.tms.resources;

import com.codahale.metrics.annotation.Timed;
import com.oracletest.tms.TMSDBFactory;
import com.oracletest.tms.facade.TaskActionFacade;
import com.oracletest.tms.model.Task;
import com.oracletest.tms.model.TaskAction;
import com.oracletest.tms.model.TaskConstants;
import lombok.extern.slf4j.Slf4j;

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
    public Task getTaskById(@PathParam("id") Optional<Integer> id) {
        return new Task(
            1, "short desc", "long desc", LocalDate.now(), LocalDate.now(),
            "SomeUser", "OPEN"
        );
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

    @Path("/mytasks")
    @GET
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public List<Task> findMyTasks(@HeaderParam("user") String user) {
        log.info("user supplied from client = {}", user);
        assert user != null;
        return taskRepository.findTaskByUser(user);
    }

}

