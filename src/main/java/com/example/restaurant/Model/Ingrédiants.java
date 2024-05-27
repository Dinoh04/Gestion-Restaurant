package com.example.restaurant.Model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@AllArgsConstructor
@Getter
@Setter
public class Ingrédiants {
    private int ingrediantId;
    private String ingrediantName;
    private Double unitPrice;
    private Instant date;
    private int quantityId;
    private int movementId;
}
