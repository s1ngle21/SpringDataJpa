package app.repository.order;

import app.entity.Order;

import java.util.List;

public interface OrderRepository {
    Order add(Order order);
    Order getById(Long id);
    List<Order> getAll();
    void delete(Long id);
}
