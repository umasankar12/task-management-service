package com.oracletest.tms;

import com.oracletest.tms.resources.TaskResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Slf4j
public class TaskManagementApp extends Application<TaskManagementConfig> {

    public static void main(String[] args) throws Exception{
        log.info("This is a test message");
        new TaskManagementApp().run(args);
    }

    @Override
    public void run(TaskManagementConfig configuration, Environment environment) throws Exception {
        System.out.println("Hello from Dropwizard");
        environment.jersey()
            .register(new TaskResource("", ""));

    }

    @Override
    public void initialize(Bootstrap<TaskManagementConfig> bootstrap) {
        super.initialize(bootstrap);
        System.out.println("initialize called..");
    }
}
