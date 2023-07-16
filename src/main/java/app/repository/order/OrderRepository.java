package app.repository.order;

import app.entity.Order;

import java.util.List;
import java.util.UUID;

public interface OrderRepository {
    Order add(Order order);

    Order getById(UUID id);

    List<Order> getAll();

    void delete(UUID id);
}
