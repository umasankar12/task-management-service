package com.oracletest.tms.facade;

import java.util.List;
import java.util.Optional;

public interface DBRepository<T, IdType> {

    public boolean create(T model);

    public Optional<T> findById(IdType id);

    public List<T> fetchAll();

}
