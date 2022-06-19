package ru.netology.domain;

import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data

public class Product {
    protected int id;
    protected int cost;
    protected String title;

    public Product(int id, int cost, String title) {
        this.id = id;
        this.cost = cost;
        this.title = title;
    }
}
