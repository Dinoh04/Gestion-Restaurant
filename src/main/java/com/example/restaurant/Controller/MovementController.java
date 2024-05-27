package com.example.restaurant.Controller;


import com.example.restaurant.Model.MovementStock;
import com.example.restaurant.Model.ShowMovementStock;
import com.example.restaurant.Service.MovementService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.time.Instant;
import java.util.List;

@RestController
@AllArgsConstructor
public class MovementController {
    private MovementService service;

    @GetMapping("/movement")
    public List<MovementStock> getAllMovement() throws SQLException{
        return service.findAll();
    }

    @PostMapping("/movement")
    public MovementStock createMovement(@RequestBody MovementStock toSave) throws  SQLException{
        return  service.save(toSave);
    }

    @PutMapping("/movement/{id}")
    public MovementStock updateMovement(@PathVariable("id") int id, @RequestBody MovementStock toUpdate) throws  SQLException{
        return service.update(id, toUpdate);
    }

    @GetMapping("/stock-movements")
    public List<ShowMovementStock> getStockMovements(
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Instant startDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Instant endDate
    ) throws SQLException{


      return service.showAll(startDate,endDate);
    }
}
