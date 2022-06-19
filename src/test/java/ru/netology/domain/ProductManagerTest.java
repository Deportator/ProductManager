package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductManagerTest {

    Book book1 = new Book(12, 550, "Метро 2033", "Глуховский");
    Book book2 = new Book(24, 780, "Спартак", "Джованьоли");
    Book book3 = new Book(31, 1500, "Шантарам", "Робертс");

    Smartphone smartphone1 = new Smartphone(10, 35000, "Iphone", "Apple");
    Smartphone smartphone2 = new Smartphone(23, 30000, "Readmi", "Xiaomi");
    Smartphone smartphone3 = new Smartphone(34, 25000, "Galaxy", "Samsung");

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    @Test
    public void shouldSaveAllProducts() {
        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(smartphone1);
        repo.save(smartphone2);
        repo.save(smartphone3);

        Product[] actual = repo.findAll();
        Product[] expected = {book1, book2, book3, smartphone1, smartphone2, smartphone3};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSaveOneProduct() {
        repo.save(book1);


        Product[] actual = repo.findAll();
        Product[] expected = {book1};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotSaveProducts() {

        Product[] actual = repo.findAll();
        Product[] expected = {};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdOne() {
        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(smartphone1);
        repo.save(smartphone2);
        repo.save(smartphone3);

        repo.removeById(23);

        Product[] actual = repo.findAll();
        Product[] expected = {book1, book2, book3, smartphone1, smartphone3};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdThree() {
        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(smartphone1);
        repo.save(smartphone2);
        repo.save(smartphone3);

        repo.removeById(23);
        repo.removeById(12);
        repo.removeById(31);

        Product[] actual = repo.findAll();
        Product[] expected = {book2, smartphone1, smartphone3};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdAll() {
        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(smartphone1);
        repo.save(smartphone2);
        repo.save(smartphone3);

        repo.removeById(12);
        repo.removeById(24);
        repo.removeById(31);
        repo.removeById(10);
        repo.removeById(23);
        repo.removeById(34);


        Product[] actual = repo.findAll();
        Product[] expected = {};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddProduct() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] actual = manager.searchBy("Спартак");
        Product[] expected = {book2};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddProducts() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] actual = manager.searchBy("ар");
        Product[] expected = {book2, book3};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldsearchByProducts() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] actual = manager.searchBy("a");
        Product[] expected = {smartphone2, smartphone3};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotAddProducts() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] actual = manager.searchBy("ром");
        Product[] expected = {};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotAdd() {

        Product[] actual = manager.searchBy("ар");
        Product[] expected = {};

        assertArrayEquals(expected, actual);
    }
}
