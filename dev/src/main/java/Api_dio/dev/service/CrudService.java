package Api_dio.dev.service;

import java.util.List;

public interface CrudService<ID, T> {
    List<T> findAll();
    T findById(ID id);
    T save(T t);
    void delete(T t);
    T update(ID id, T entity);
}
