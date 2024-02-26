package com.example.tp_hopital.interfaces;

import java.util.List;

public interface Repository<T> {

    boolean create(T o);

    boolean update(T o);

    boolean delete(T o);

    T findById(Long id);

    List<T> findAll();
}
