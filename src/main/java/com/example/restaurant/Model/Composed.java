package com.example.restaurant.Model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Composed {
    private int menuId;
    private int ingredientId;
    private Double quantityRequired;
}
