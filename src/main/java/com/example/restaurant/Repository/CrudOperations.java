package com.example.restaurant.Repository;

import java.sql.SQLException;
import java.util.List;

public interface CrudOperations <T>{
    public List<T> findAll() throws SQLException;
    public T save(T toSave) throws SQLException;
    public T update(int id, T toUpdate) throws SQLException;
    public void  delete( int toDelete) throws SQLException;
}
