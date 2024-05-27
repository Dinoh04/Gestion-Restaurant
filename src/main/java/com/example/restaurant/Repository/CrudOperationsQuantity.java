package com.example.restaurant.Repository;

import com.example.restaurant.Model.Quantity;
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
public class CrudOperationsQuantity implements CrudOperations<Quantity>{
    private Connection connection;
    @Override
    public List<Quantity> findAll() throws SQLException {
        List<Quantity> allQuantity = new ArrayList<>();
        String sql = "SELECT * FROM quantity";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                allQuantity.add(new Quantity(
                        resultSet.getInt("quantity_id"),
                        resultSet.getString("quantity_name")
                ));
            }

        }
        return allQuantity;
    }

    @Override
    public Quantity save(Quantity toSave) throws SQLException {
        String sql = "INSERT INTO quantity( quantity_name) VALUES (?)";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, toSave.getQuantityName());

            preparedStatement.executeUpdate();
        }
        return toSave;
    }

    @Override
    public Quantity update(int id, Quantity toUpdate) throws SQLException {
        return null;
    }

    @Override
    public void delete(int toDelete) throws SQLException {

    }
}
