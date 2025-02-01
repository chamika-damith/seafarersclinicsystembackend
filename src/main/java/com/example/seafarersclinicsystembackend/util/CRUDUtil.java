package com.example.seafarersclinicsystembackend.util;

import java.util.List;

public interface CRUDUtil <T>{
    void save(T dto);
    void delete(String id);
    void update(String id, T dto);
    T get(String id);
    List<T> getAll();
}
