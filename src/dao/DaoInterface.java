package dao;

import java.util.List;

public interface DaoInterface <T> {

    void insert(T t);
    void update(T t,int id);
    void delete(int id);
    T search(int id);
    List<T> searchAll();

}
