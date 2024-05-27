package com.example.restaurant.Service;


import com.example.restaurant.Model.Ingrédiants;
import com.example.restaurant.Model.Quantity;
import com.example.restaurant.Repository.CrudOperationsIngrediants;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.Instant;
import java.util.List;

@Service
@AllArgsConstructor
public class IngrediantService {
    private CrudOperationsIngrediants repository;

    public Ingrédiants createIngrediant(Ingrédiants toSave) throws SQLException{
        if(toSave.getDate() == null){
            toSave.setDate(Instant.now());
        }
        return repository.save(toSave);
    }
    public List<Ingrédiants> findAll() throws  SQLException{
        return repository.findAll();
    }
}
