package com.oracletest.tms.facade;

import com.oracletest.tms.TMSDBFactory;
import org.jdbi.v3.core.Jdbi;

public  class TMSDBRepository {

    protected TMSDBFactory dbFactory;

    public TMSDBRepository(TMSDBFactory dbFactory) {
        this.dbFactory = dbFactory;
    }

    public TMSDBFactory getDbFactory() {
        return dbFactory;
    }

    protected Jdbi getJdbi() {
        return dbFactory.getJdbi();
    }

}
