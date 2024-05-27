package com.example.restaurant.Controller;

import com.example.restaurant.Model.Restaurant;
import com.example.restaurant.Service.RestaurantService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@AllArgsConstructor
public class RestaurantController {
    private RestaurantService service;

    @PostMapping("/restaurant")
    public Restaurant createRestaurant(@RequestBody Restaurant toSave) throws SQLException{
        return service.save(toSave);
    }

    @GetMapping("/restaurant")
    public List<Restaurant> getAllRestaurant() throws  SQLException{
        return  service.findAll();
    }
}
