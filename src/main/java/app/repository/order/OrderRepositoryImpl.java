package app.repository.order;

import app.entity.Order;
import app.repository.product.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class OrderRepositoryImpl implements OrderRepository {
    private ProductRepository productRepository;
    private Map<UUID, Order> orders;

    public OrderRepositoryImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
        this.orders = new HashMap<>();
    }


    public Order add(Order order) {
        orders.put(order.getId(), order);
        return order;
    }

    public Order getById(UUID id) {
        return orders.get(id);
    }

    public List<Order> getAll() {
        return new ArrayList<>(orders.values());
    }

    public void delete(UUID id) {
        orders.remove(id);
    }


}
