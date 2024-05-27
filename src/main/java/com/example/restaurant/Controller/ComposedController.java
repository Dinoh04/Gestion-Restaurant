package com.example.restaurant.Controller;


import com.example.restaurant.Model.Composed;
import com.example.restaurant.Service.ComposedService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@AllArgsConstructor
public class ComposedController {
    private ComposedService service;

    @GetMapping("/composed")
    public List<Composed> getAllComposed() throws SQLException{
        return service.findAll();
    }

    @PostMapping("/composed")
    public Composed createComposed(@RequestBody Composed toSave) throws SQLException{
        return  service.save(toSave);
    }

    @PutMapping("/composed/{id}")
    public Composed updateComposed(@PathVariable("id") int id, @RequestBody Composed toUpdate) throws  SQLException{
        return service.update(id,toUpdate);
    }

    @DeleteMapping("/composed/{id}")
    public void deleteIngredient(@PathVariable("id") int id) throws SQLException{
        service.delete(id);
    }
}
