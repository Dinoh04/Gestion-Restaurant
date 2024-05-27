package com.example.restaurant.Service;


import com.example.restaurant.Model.Menu;
import com.example.restaurant.Repository.CrudOperationsMenu;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
@AllArgsConstructor
public class MenuService {
    private CrudOperationsMenu repository;

    public Menu save(Menu toSave) throws SQLException{
        return repository.save(toSave);
    }
    public List<Menu> findAll() throws  SQLException{
        return repository.findAll();
    }
}
