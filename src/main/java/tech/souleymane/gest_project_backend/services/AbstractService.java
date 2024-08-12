package tech.souleymane.gest_project_backend.services;

import java.util.List;

public interface AbstractService<T> {
    public void save(T t);
    public void delete(T t);
    public void update(T t);
    public List<T> getAll();
    public T getById(int id);
}
