package app.entity;


import lombok.*;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Order {

    private UUID id;

    private double cost;

    private LocalDateTime createdAt;

    private List<Product> products;

    public Order(double cost, LocalDateTime createdAt) {
        this.id = UUID.randomUUID();
        this.cost = cost;
        this.createdAt = createdAt;
        this.products = new ArrayList<>();
    }

    public Order() {
        this.id = UUID.randomUUID();
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

}
