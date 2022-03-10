package com.oracletest.tms;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TaskManagementApp extends Application<TaskManagementConfig> {

    public static void main(String[] args) throws Exception{
        log.info("This is a test message");
        new TaskManagementApp().run(args);
    }

    @Override
    public void run(TaskManagementConfig configuration, Environment environment) throws Exception {
        System.out.println("Hello from Dropwizard");
    }

    @Override
    public void initialize(Bootstrap<TaskManagementConfig> bootstrap) {
        super.initialize(bootstrap);
        System.out.println("initialize called..");
    }
}
