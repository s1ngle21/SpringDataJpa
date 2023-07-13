package app.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Order {

    private Long id;

    private static Long nextId = 1L;

    private double cost;

    private LocalDateTime createdAt;

    private List<Product> products;

    public Order(double cost, LocalDateTime createdAt) {
        this.id = nextId++;
        this.cost = cost;
        this.createdAt = createdAt;
        this.products = new ArrayList<>();
    }

    public Order() {
        this.id = nextId++;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

}
