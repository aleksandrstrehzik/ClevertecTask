package com.clevertec_task.repository;

import java.sql.SQLException;

public interface DAO<T> {

    void save(T t);

    T selectById(int id) throws SQLException;

    void update(T t) throws SQLException;

    void delete(T t) throws SQLException;

}
