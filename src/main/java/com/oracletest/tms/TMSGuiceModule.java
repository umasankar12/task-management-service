package com.oracletest.tms;

import com.google.inject.AbstractModule;
import io.dropwizard.jdbi3.JdbiFactory;

public class TMSGuiceModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(JdbiFactory.class).asEagerSingleton();
    }

}
