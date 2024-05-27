package com.example.restaurant.Model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@AllArgsConstructor
@Getter
@Setter
public class ShowMovementStock {
    private int movementId;
    private String movementName;
    private Double quantityRemaining;
    private Double quantity_provided;
    private Instant movementDate;
    private Double quantitySell;
    private int ingredientId;
    private String ingredientName;
}
