package app.service.order;

import app.entity.Order;

import java.util.List;

public interface OrderService {
    Order getById(Long id);

    List<Order> getAll();

    Order add(Order order);

    void delete(Long id);

}
