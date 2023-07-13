package app.controller;

import app.entity.Order;
import app.entity.Product;
import app.service.order.OrderService;
import app.service.product.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "/orders")
@AllArgsConstructor
@Transactional
public class OrderController {

    private OrderService orderService;
    private ProductService productService;

    @PostMapping("/{orderId}/products/{productId}")
    ResponseEntity<?> addProductToOrder(@PathVariable(name = "orderId") Long orderId,
                                        @PathVariable(name = "productId") Long productId) {
        Order order = orderService.getById(orderId);
        Optional<Product> product = productService.getById(productId);

        order.addProduct(product.get());
        product.get().setOrderId(orderId);
        return ResponseEntity.ok("Product added to order successfully");
    }

    @PostMapping("/products/{productId}")
    ResponseEntity<?> createOrderByAddingProduct(@PathVariable(name = "productId") Long productId) {
        Optional<Product> product = productService.getById(productId);
        Order order = new Order();
        order.setCreatedAt(LocalDateTime.now());
        order.setCost(order.getCost() + product.get().getCost());
        order.addProduct(product.get());
        Order addedOrder = orderService.add(order);
        product.get().setOrderId(addedOrder.getId());
        return ResponseEntity
                .ok("Product added to new order successfully");
    }



    @GetMapping("/{id}")
    @ResponseBody
    @Transactional(readOnly = true)
    public ResponseEntity<Order> getById(@PathVariable(name = "id") @RequestBody Long id) {
        Order order = orderService.getById(id);
        return ResponseEntity
                .ok()
                .body(order);
    }

    @GetMapping
    @Transactional(readOnly = true)
    public ResponseEntity<?> getAll() {
        List<Order> orders = orderService.getAll();
        return ResponseEntity
                .ok()
                .body(orders);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") @RequestBody Long id) {
        orderService.delete(id);
        return ResponseEntity
                .ok()
                .header("Order has been deleted", UUID.randomUUID().toString())
                .build();
    }
}
