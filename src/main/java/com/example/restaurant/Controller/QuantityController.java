package com.example.restaurant.Controller;


import com.example.restaurant.Model.Quantity;
import com.example.restaurant.Repository.CrudOperationsQuantity;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@AllArgsConstructor
public class QuantityController {
    private CrudOperationsQuantity service;

    @GetMapping("/quantity")
    public List<Quantity> getAllQuantity () throws SQLException{
        return service.findAll();
    }

    @PostMapping("/quantity")
    public Quantity createQuantity(@RequestBody Quantity toSave) throws  SQLException{
        return service.save(toSave);
    }
}
