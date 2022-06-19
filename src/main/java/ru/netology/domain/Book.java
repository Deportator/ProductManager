package ru.netology.domain;
public class Book extends Product {
    private String author;

    public Book(int id, int cost, String title, String author) {
        super(id, cost, title);
        this.author = author;
    }
}
