package com.example.restaurant.Model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Menu {
    private int MenuId;
    private String menuName;
    private int restaurantId;

}
