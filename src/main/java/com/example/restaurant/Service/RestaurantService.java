package com.example.restaurant.Service;


import com.example.restaurant.Model.Restaurant;
import com.example.restaurant.Repository.CrudOperationsRestaurant;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
@AllArgsConstructor
public class RestaurantService {
    private CrudOperationsRestaurant repository;

    public List<Restaurant> findAll() throws SQLException {
        return repository.findAll();
    }
    public Restaurant save(Restaurant toSave) throws SQLException{
        return  repository.save(toSave);
    }
}
