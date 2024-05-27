package com.example.restaurant.Controller;


import com.example.restaurant.Model.Menu;
import com.example.restaurant.Service.MenuService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@AllArgsConstructor
public class MenuController {
    private MenuService service;

    @GetMapping("/menu")
    public List<Menu> getAllMenu() throws SQLException{
        return service.findAll();
    }

    @PostMapping("/menu")
    public Menu createMenu(@RequestBody Menu toSave) throws SQLException{
        return service.save(toSave);
    }
}
