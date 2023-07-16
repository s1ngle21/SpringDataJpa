package app.service.order;

import app.entity.Order;
import app.entity.Product;
import app.repository.order.OrderRepository;
import app.service.product.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
@Transactional
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private ProductService productService;

    @Override
    @Transactional(readOnly = true)
    public Order getById(UUID id) {
        return orderRepository.getById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Order> getAll() {
        return orderRepository.getAll();
    }

    @Override
    public Order add(Order order) {
        return orderRepository.add(order);
    }

    @Override
    public void delete(UUID id) {
        orderRepository.delete(id);
    }

    @Override
    public Order addProductToOrder(UUID orderId, Long productId) {
        Order order = getById(orderId);
        Optional<Product> product = productService.getById(productId);
        order.addProduct(product.get());
        order.setCost(order.getCost() + product.get().getCost());
        return order;
    }

    @Override
    public Order createOrderByAddingProduct(Long productId) {
        Optional<Product> product = productService.getById(productId);
        Order order = new Order();
        order.setCreatedAt(LocalDateTime.now());
        order.setCost(product.get().getCost());
        order.addProduct(product.get());
        return orderRepository.add(order);
    }
}
