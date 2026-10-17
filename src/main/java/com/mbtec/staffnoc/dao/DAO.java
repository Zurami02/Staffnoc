package com.mbtec.staffnoc.dao;

import java.util.List;

public interface DAO<T> {
    void create(T entity);
    List<T>list();
    void update(T entity);
    void delete(int id);
    List<T> search(String term);
}
