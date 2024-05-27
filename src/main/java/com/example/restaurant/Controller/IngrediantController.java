package com.example.restaurant.Controller;

import com.example.restaurant.Model.Ingrédiants;
import com.example.restaurant.Service.IngrediantService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;


@RestController
@AllArgsConstructor
public class IngrediantController {
    private IngrediantService service;

    @GetMapping("/Ingrediant")
    public List<Ingrédiants> getAllIngrediants () throws SQLException{
        return service.findAll();
    }

    @PostMapping("/Ingrediant")
    public Ingrédiants createIngrediant(@RequestBody Ingrédiants toSave) throws SQLException{
        return  service.createIngrediant(toSave);
    }
}
