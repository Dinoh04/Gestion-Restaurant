package com.example.restaurant.Repository;

import com.example.restaurant.Model.Menu;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Repository
public class CrudOperationsMenu implements CrudOperations<Menu>{

    private Connection connection;

    @Override
    public List<Menu> findAll() throws SQLException {
        List<Menu> allMenu = new ArrayList<>();
        String sql = "SELECT * FROM Menu";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                allMenu.add(new Menu(
                        resultSet.getInt("menu_id"),
                        resultSet.getString("menu_name"),
                        resultSet.getInt("restaurant_id")
                ));
            }

        }
        return allMenu;
    }

    @Override
    public Menu save(Menu toSave) throws SQLException {
        String sql = "INSERT INTO Menu (menu_name,restaurant_id) VALUES (?,?)";
        try(PreparedStatement insertStatement = connection.prepareStatement(sql)){
            insertStatement.setString(1, toSave.getMenuName());
            insertStatement.setInt(2, toSave.getRestaurantId());

            insertStatement.executeUpdate();

        }
        return toSave;
    }

    @Override
    public Menu update(int id, Menu toUpdate) throws SQLException {
        return null;
    }

    @Override
    public void delete(int toDelete) throws SQLException {

    }
}
