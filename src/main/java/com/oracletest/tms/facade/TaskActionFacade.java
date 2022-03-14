package com.oracletest.tms.facade;

import com.oracletest.tms.TMSDBFactory;
import com.oracletest.tms.model.Task;
import com.oracletest.tms.model.TaskAction;
import com.oracletest.tms.model.TaskConstants;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import javax.inject.Named;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Named
@Slf4j
public class TaskActionFacade extends TMSDBRepository {

    @Inject
    public TaskActionFacade(TMSDBFactory tmsdbFactory) {
        super(tmsdbFactory);
    }

    public boolean create(Task model) {
        String insertQuery = "INSERT INTO Task(short_desc, long_desc, create_date, target_date, created_by, status) values " +
            "(:shortDesc, :longDesc, current_timestamp, :targetDate, :createdBy, 'OPEN') returning *";
        getJdbi().withHandle(h ->
            h.createUpdate(insertQuery)
                .bind("shortDesc", model.getShortDesc())
                .bind("longDesc", model.getLongDesc())
                .bind("targetDate", model.getTargetDate())
                .bind("createdBy", model.getCreatedBy())
                .execute()
        );
        return true;
    }

    public Optional<Task> findById(Integer id) {
        String sql = "SELECT * FROM Task where Id=?";
        return Optional.empty();
    }

    public List<Task> fetchAll() {
        return null;
    }

    public List<Task> findTaskByUser(String user) {
        return dao().findByUser(user);
    }

    public Task persist(Task task) {
        return dao().create(task);
    }

    private TaskDAO dao() {
        return getJdbi().open().attach(TaskDAO.class);
    }

    public TaskAction persistTaskWithAction(Task task) {
        return getJdbi().inTransaction(handle -> {
            TaskDAO taskDAO = handle.attach(TaskDAO.class);
            Task persisted = taskDAO.create(task);
            log.info("Created Task : {}", persisted);

            log.info("Add action");
            TaskActionDAO taskActionDAO = handle.attach(TaskActionDAO.class);
            TaskAction action = new TaskAction();
            action.setTaskId(persisted.getId());
            action.setUpdateBy(persisted.getCreatedBy());
            action.setAction("create");
            action.setUpdateTime(LocalDateTime.now());
            return taskActionDAO.create(action);
        });
    }

    public TaskAction modifyTask(Task inputTask) {
        assert inputTask.getId() != 0;

        return getJdbi().inTransaction(handle -> {
            TaskDAO taskDAO = handle.attach(TaskDAO.class);
            Task persisted = taskDAO.findById(inputTask);
            log.info("Task Exists");

            log.info("Add action");
            TaskActionDAO taskActionDAO = handle.attach(TaskActionDAO.class);
            TaskAction taskAction = new TaskAction();
            taskAction.setTaskId(persisted.getId());
            taskAction.setUpdateBy(persisted.getCreatedBy());
            taskAction.setAction(inputTask.getStatus());
            taskAction.setUpdateTime(LocalDateTime.now());
            taskAction.setPrevState(persisted.toString());

            if (inputTask.getShortDesc() != null)
                persisted.setShortDesc(inputTask.getShortDesc());
            if (inputTask.getLongDesc() != null)
                persisted.setLongDesc(inputTask.getLongDesc());
            persisted.setStatus(inputTask.getStatus());
            taskDAO.update(persisted);
            log.info("updated Task : {}", persisted);

            return taskActionDAO.create(taskAction);
        });
    }


}
