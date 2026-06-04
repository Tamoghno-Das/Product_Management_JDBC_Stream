package com.example.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Product
{
    private int productId;
    private String productName;
    private String category;
    private double price;
    private int quantity;

}
