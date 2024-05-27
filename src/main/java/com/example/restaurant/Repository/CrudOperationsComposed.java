package com.example.restaurant.Repository;


import com.example.restaurant.Model.Composed;
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
public class CrudOperationsComposed implements CrudOperations<Composed>{
    private Connection connection;

    @Override
    public List<Composed> findAll() throws SQLException {
        List<Composed> allComposed = new ArrayList<>();
        String sql = "SELECT * FROM composed";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                allComposed.add(new Composed(
                        resultSet.getInt("menu_id"),
                        resultSet.getInt("ingredient_id"),
                        resultSet.getDouble("quantity_required")
                ));
            }

        }
        return allComposed;
    }

    @Override
    public Composed save(Composed toSave) throws SQLException {
        String sql = "INSERT INTO composed (menu_id, ingredient_id,quantity_required) VALUES (?,?,?)";
        try(PreparedStatement insertStatement = connection.prepareStatement(sql)){
          insertStatement.setInt(1, toSave.getMenuId());
          insertStatement.setInt(2, toSave.getIngredientId());
          insertStatement.setDouble(3, toSave.getQuantityRequired());

          insertStatement.executeUpdate();
        }
        return toSave;
    }

    @Override
    public Composed update(int id, Composed toUpdate) throws SQLException {
        String sql = "UPDATE composed set menu_id = ?, ingredient_id = ? WHERE ingredient_id = ?";
        try(PreparedStatement updateStatement = connection.prepareStatement(sql)){
         updateStatement.setInt(1, toUpdate.getMenuId());
         updateStatement.setInt(2, toUpdate.getIngredientId());
         updateStatement.setInt(3, id);

         updateStatement.executeUpdate();
        }
        return toUpdate;
    }

    @Override
    public void delete(int toDelete) throws SQLException {
        String sql = "DELETE FROM composed WHERE ingredient_id = ?";

        try(PreparedStatement deleteStatement = connection.prepareStatement(sql)){
            deleteStatement.setInt(1, toDelete);
            deleteStatement.executeUpdate();
        }
    }
}
