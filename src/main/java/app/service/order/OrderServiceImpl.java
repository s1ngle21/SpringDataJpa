package app.service.order;

import app.entity.Order;
import app.repository.order.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepositoryImpl) {
        this.orderRepository = orderRepositoryImpl;
    }

    @Override
    public Order getById(Long id) {
        return orderRepository.getById(id);
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.getAll();
    }

    @Override
    public Order add(Order order) {
        return orderRepository.add(order);
    }

    @Override
    public void delete(Long id) {
        orderRepository.delete(id);
    }
}
