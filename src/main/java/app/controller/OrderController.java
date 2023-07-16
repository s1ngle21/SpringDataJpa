package app.controller;

import app.entity.Order;
import app.service.order.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping(value = "/orders")
@AllArgsConstructor
public class OrderController {

    private OrderService orderService;


    @PostMapping("/{orderId}/products/{productId}")
    ResponseEntity<Order> addProductToOrder(@PathVariable(name = "orderId") UUID orderId,
                                            @PathVariable(name = "productId") Long productId) {
        Order order = orderService.addProductToOrder(orderId, productId);
        return ResponseEntity.ok(order);
    }

    @PostMapping("/products/{productId}")
    ResponseEntity<Order> createOrderByAddingProduct(@PathVariable(name = "productId") Long productId) {
        Order order = orderService.createOrderByAddingProduct(productId);
        return ResponseEntity
                .ok(order);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Order> getById(@PathVariable(name = "id") UUID id) {
        Order order = orderService.getById(id);
        return ResponseEntity
                .ok()
                .body(order);
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAll() {
        List<Order> orders = orderService.getAll();
        return ResponseEntity
                .ok()
                .body(orders);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable(name = "id") UUID id) {
        orderService.delete(id);
        return ResponseEntity
                .ok("Order has been deleted");
    }
}
