package app.service.order;

import app.entity.Order;

import java.util.List;
import java.util.UUID;

public interface OrderService {
    Order getById(UUID id);

    List<Order> getAll();

    Order add(Order order);

    void delete(UUID id);

    Order addProductToOrder(UUID orderId, Long productId);

    Order createOrderByAddingProduct(Long productId);

}
