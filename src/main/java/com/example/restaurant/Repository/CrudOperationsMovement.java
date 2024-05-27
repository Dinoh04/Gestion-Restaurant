package com.example.restaurant.Repository;

import com.example.restaurant.Model.MovementStock;
import com.example.restaurant.Model.ShowMovementStock;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Repository
@AllArgsConstructor
public class CrudOperationsMovement implements CrudOperations<MovementStock>{
    private Connection connection;
    @Override
    public List<MovementStock> findAll() throws SQLException {
        List<MovementStock> allMovement = new ArrayList<>();
        String sql = "SELECT * FROM Movement";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                allMovement.add(new MovementStock(
                        resultSet.getInt("movement_id"),
                        resultSet.getString("movement_name"),
                        resultSet.getDouble("quantity_remaining"),
                        resultSet.getDouble("quantity_provided"),
                        resultSet.getTimestamp("movement_date").toInstant(),
                        resultSet.getDouble("quantity_sell")
                ));
            }
        }
        return allMovement;
    }

    @Override
    public MovementStock save(MovementStock toSave) throws SQLException {
        String sql = "INSERT INTO movement (movement_name,quantity_remaining,quantity_provided,movement_date,quantity_sell) VALUES(?,?,?,?,?)";
        try(PreparedStatement insertStatement = connection.prepareStatement(sql)){
            insertStatement.setString(1, toSave.getMovementName());
            insertStatement.setDouble(2, toSave.getQuantityRemaining());
            insertStatement.setDouble(3, toSave.getQuantity_provided());
            insertStatement.setTimestamp(4, Timestamp.from(toSave.getMovementDate()));
            insertStatement.setDouble(5, toSave.getQuantitySell());

            insertStatement.executeUpdate();

        }
        return toSave;
    }

    @Override
    public MovementStock update(int id, MovementStock toUpdate) throws SQLException {
        String sql = "UPDATE movement set movement_name = ?, quantity_remaining = ?, quantity_provided = ?, movement_date= ?, quantity_sell = ? WHERE movement_id = ?";
        try(PreparedStatement updateStatement = connection.prepareStatement(sql)){
            updateStatement.setString(1,toUpdate.getMovementName());
            updateStatement.setDouble(2, toUpdate.getQuantityRemaining());
            updateStatement.setDouble(3, toUpdate.getQuantity_provided());
            updateStatement.setTimestamp(4, Timestamp.from(toUpdate.getMovementDate()));
            updateStatement.setDouble(5, toUpdate.getQuantitySell());
            updateStatement.setInt(6, id);

            updateStatement.executeUpdate();
        }
        return toUpdate;
    }

    @Override
    public void delete(int toDelete) throws SQLException {

    }public List<ShowMovementStock> showMovementStock(Instant startDate, Instant endDate) throws SQLException {
        List<ShowMovementStock> movementStocks = new ArrayList<>();
        String sql = "SELECT " +
                "m.movement_id, " +
                "m.movement_name, " +
                "m.quantity_remaining, " +
                "m.quantity_provided, " +
                "m.movement_date, " +
                "m.quantity_sell, " +
                "i.ingredient_id, " +
                "i.ingredient_name " +
                "FROM " +
                "movement m " +
                "JOIN ingredient i ON i.ingredient_id = m.movement_id " +
                "WHERE " +
                "m.movement_date BETWEEN ? AND ? " +
                "ORDER BY " +
                "i.ingredient_id, " +
                "m.movement_date";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setTimestamp(1, Timestamp.from(startDate));
            preparedStatement.setTimestamp(2, Timestamp.from(endDate));

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                movementStocks.add(new ShowMovementStock(
                        resultSet.getInt("movement_id"),
                        resultSet.getString("movement_name"),
                        resultSet.getDouble("quantity_remaining"),
                        resultSet.getDouble("quantity_provided"),
                        resultSet.getTimestamp("movement_date").toInstant(),
                        resultSet.getDouble("quantity_sell"),
                        resultSet.getInt("ingredient_id"),
                        resultSet.getString("ingredient_name")
                ));
            }
        }

        return movementStocks;
    }


}
