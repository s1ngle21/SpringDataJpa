package app.controller;

import app.entity.Product;
import app.service.product.ProductService;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/products")
@AllArgsConstructor
public class ProductController {

    private ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable(name = "id") Long id) {
        return ResponseEntity
                .ok(this.productService.getById(id).get());
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity
                .ok(this.productService.getAll());
    }

    @PostMapping
    public ResponseEntity<Product> add(@RequestBody Product product) {
        Product addedProduct = this.productService.add(product);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(addedProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable(name = "id") Long id) {
        this.productService.delete(id);
        return ResponseEntity
                .ok("Product has been deleted");
    }


}
