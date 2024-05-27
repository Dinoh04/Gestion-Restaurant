package com.example.restaurant.Service;


import com.example.restaurant.Model.Quantity;
import com.example.restaurant.Repository.CrudOperationsQuantity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
@AllArgsConstructor
public class QuantityService {
    private CrudOperationsQuantity repository;

    public Quantity createQuantity(Quantity toSave) throws SQLException{
        return repository.save(toSave);
    }
}
