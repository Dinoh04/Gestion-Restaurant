package com.example.restaurant.Repository;

import com.example.restaurant.Model.Ingrédiants;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
@AllArgsConstructor
public class CrudOperationsIngrediants implements CrudOperations<Ingrédiants>{
    private Connection connection;
    @Override
    public List<Ingrédiants> findAll() throws SQLException {
        List<Ingrédiants> allIngrediant = new ArrayList<>();
        String sql = "SELECT * FROM ingredient";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                allIngrediant.add(new Ingrédiants(
                        resultSet.getInt("ingredient_id"),
                        resultSet.getString("ingredient_name"),
                        resultSet.getDouble("unit_price"),
                        resultSet.getTimestamp("date").toInstant(),
                        resultSet.getInt("quantity_id"),
                        resultSet.getInt("movement_id")
                ));
            }

        }
        return allIngrediant;
    }

    @Override
    public Ingrédiants save(Ingrédiants toSave) throws SQLException {
        String sql = "INSERT INTO ingredient(ingredient_name ,unit_price,date,quantity_id,movement_id) VALUES (?,?,?,?,?)";
        try(PreparedStatement insertStatement = connection.prepareStatement(sql)){
            insertStatement.setString(1, toSave.getIngrediantName());
            insertStatement.setDouble(2, toSave.getUnitPrice());
            insertStatement.setTimestamp(3, Timestamp.from(toSave.getDate()));
            insertStatement.setInt(4, toSave.getQuantityId());
            insertStatement.setInt(5,toSave.getMovementId());

            insertStatement.executeUpdate();
        }
        return toSave;
    }

    @Override
    public Ingrédiants update(int id, Ingrédiants toUpdate) throws SQLException {
        return null;
    }

    @Override
    public void delete(int toDelete) throws SQLException {

    }
}
