package com.clevertec_task.repository.dao.interfaces;

public interface DAO<T> {

    void save(T t);

    T selectById(int id);

    void update(T t);

    void delete(T t);

}
