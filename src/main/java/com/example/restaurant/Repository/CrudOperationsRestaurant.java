package com.example.restaurant.Repository;

import com.example.restaurant.Model.Restaurant;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
@AllArgsConstructor
public class CrudOperationsRestaurant implements  CrudOperations<Restaurant>{

    private Connection connection;
    @Override
    public List<Restaurant> findAll() throws SQLException {
        List<Restaurant> allRestaurant = new ArrayList<>();
        String sql = "SELECT * FROM Restaurant";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                allRestaurant.add(new Restaurant(
                        resultSet.getInt("restaurant_id"),
                        resultSet.getString("address")
                ));
            }

        }

        return allRestaurant;
    }

    @Override
    public Restaurant save(Restaurant toSave) throws SQLException {
        String sql = "INSERT INTO Restaurant (address) VALUES (?)";
        try(PreparedStatement insertStatement = connection.prepareStatement(sql)){
            insertStatement.setString(1, toSave.getAddress());

            insertStatement.executeUpdate();

        }
        return toSave;
    }

    @Override
    public Restaurant update(int id, Restaurant toUpdate) throws SQLException {
        return null;
    }

    @Override
    public void delete(int toDelete) throws SQLException {

    }
}
