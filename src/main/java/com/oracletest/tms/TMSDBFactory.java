package com.oracletest.tms;

import io.dropwizard.Configuration;
import io.dropwizard.jdbi3.JdbiFactory;
import io.dropwizard.setup.Environment;
import org.jdbi.v3.core.Jdbi;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class TMSDBFactory {

    private final JdbiFactory jdbiFactory;
    private final Environment environment;
    private final TaskManagementConfig configuration;

    @Inject
    public TMSDBFactory(JdbiFactory jdbiFactory, Environment environment, TaskManagementConfig configuration) {
        this.jdbiFactory = jdbiFactory;
        this.environment = environment;
        this.configuration = configuration;
    }

    public Jdbi getJdbi() {
        return jdbiFactory.build(environment, configuration.getDataSourceFactory(), "postgres");
    }
}
