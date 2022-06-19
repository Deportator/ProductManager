package ru.netology.domain;
public class Smartphone extends Product {
    private String manufacturer;

    public Smartphone(int id, int cost, String title, String manufacturer) {
        super(id, cost, title);
        this.manufacturer = manufacturer;
    }
}
