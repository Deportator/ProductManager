package ru.netology.domain;
public class ProductManager extends Product {
       // добавьте необходимые поля, конструкторы и методы
       private ProductRepository repository;

    public ProductManager(ProductRepository repository) {

        this.repository = repository;
    }

    public void add (Product product) {
        repository.save(product);
    }


    public Product[] searchBy(String text) {
            Product[] result = new Product[0]; // тут будем хранить подошедшие запросу продукты
            for (Product product: repository.findAll()) {
                if (matches(product, text)) {
                    // "добавляем в конец" массива result продукт product
                    Product[] tmp = new Product[result.length + 1];
                    System.arraycopy(result, 0, tmp, 0, result.length);
                    tmp[tmp.length - 1] = product;
                    result = tmp;
                }
            }
            return result;
        }


        // метод определения соответствия товара product запросу search
        public boolean matches(Product product, String search) {
            return product.getTitle().contains(search);
            // или в одну строку:
            // return product.getName().contains(search);
        }
    }

