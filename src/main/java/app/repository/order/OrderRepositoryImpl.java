package app.repository.order;

import app.entity.Order;
import app.repository.product.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class OrderRepositoryImpl implements OrderRepository{
    private ProductRepository productRepository;
    private Map<Long, Order> orders;

    public OrderRepositoryImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
        this.orders = new HashMap<>();
    }



    public Order add(Order order) {
        orders.put(order.getId(), order);
        return order;
    }

    public Order getById(Long id) {
        return orders.get(id);
    }

    public List<Order> getAll() {
        return new ArrayList<>(orders.values());
    }

    public void delete(Long id) {
        orders.remove(id);
    }


}
