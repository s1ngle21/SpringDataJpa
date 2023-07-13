package app.repository.order;

import app.entity.Order;
import app.repository.product.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepositoryImpl implements OrderRepository{
    private ProductRepository productRepository;
    private List<Order> orders;

    public OrderRepositoryImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
        this.orders = new ArrayList<>();
    }



    public Order add(Order order) {
        orders.add(order);
        return order;
    }

    public Order getById(Long id) {
        return orders.stream()
                .filter(o -> o.getId().equals(id))
                .findFirst()
                .get();
    }

    public List<Order> getAll() {
        return orders;
    }

    public void delete(Long id) {
        orders.removeIf(o -> o.getId().equals(id));
    }


}
