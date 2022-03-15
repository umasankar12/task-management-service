package com.oracletest.tms;

import io.dropwizard.Application;
import io.dropwizard.jdbi3.bundles.JdbiExceptionsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.jetty.servlets.CrossOriginFilter;
import ru.vyarus.dropwizard.guice.GuiceBundle;

import javax.servlet.DispatcherType;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;


@Slf4j
public class TaskManagementApp extends Application<TaskManagementConfig> {

    static final String basePackage = TaskManagementApp.class.getPackageName();

    public static void main(String[] args) throws Exception {
        log.info("This is a test message");
        new TaskManagementApp().run(args);
    }

    @Override
    public void run(TaskManagementConfig configuration, Environment environment) throws Exception {
        System.out.println("Hello from Dropwizard");
        var cors = environment.servlets().addFilter("cors", CrossOriginFilter.class);
        final var jersey = environment.jersey();
        final Map<String, String> params = new HashMap<>();
        params.put("Access-Control-Allow-Origin", "*");
        params.put("Access-Control-Allow-Credentials", "true");
        params.put("Access-Control-Expose-Headers", "true");
        params.put("Access-Control-Allow-Headers", "Content-Type, X-Requested-With");
        params.put("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        cors.setInitParameters(params);
        cors.setInitParameter("allowedOrigins", "*");
        cors.setInitParameter("allowedHeaders", "X-Requested-With,Content-Type,Accept,Origin");
        cors.setInitParameter("allowedMethods", "OPTIONS,GET,PUT,POST,DELETE,HEAD");
        cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");
    }

    @Override
    public void initialize(Bootstrap<TaskManagementConfig> bootstrap) {
        super.initialize(bootstrap);
        System.out.println("initialize called..");
        bootstrap.addBundle(
            GuiceBundle.builder()
                .modules(new TMSGuiceModule())
                .enableAutoConfig(basePackage)
                .build()
        );

        //bootstrap.addBundle(new JdbiExceptionsBundle());
    }

}
