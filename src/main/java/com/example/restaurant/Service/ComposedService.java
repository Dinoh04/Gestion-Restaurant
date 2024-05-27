package com.example.restaurant.Service;


import com.example.restaurant.Model.Composed;
import com.example.restaurant.Repository.CrudOperationsComposed;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
@AllArgsConstructor
public class ComposedService {
    private CrudOperationsComposed repository;

    public Composed save(Composed toSave) throws SQLException{
       return repository.save(toSave);
    }

    public List<Composed> findAll() throws SQLException{
        return repository.findAll();
    }

    public Composed update(int id, Composed toUpdate) throws  SQLException{
        return  repository.update(id, toUpdate);
    }

    public void delete(int toDelete) throws SQLException{
        repository.delete(toDelete);
    }
}
