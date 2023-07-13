package app.controller;

import app.entity.Product;
import app.service.product.ProductService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/products")
@Transactional
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    @Transactional(readOnly = true)
    public ResponseEntity<Product> getById(@PathVariable(name = "id") Long id) {
        return ResponseEntity
                .ok(this.productService.getById(id).get());
    }

    @GetMapping
    @Transactional(readOnly = true)
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity
                .ok(this.productService.getAll());
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Product> add(@RequestBody Product product) {
        Product addedProduct = this.productService.add(product);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(addedProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {
        this.productService.delete(id);
        return ResponseEntity
                .ok("Product has been deleted");
    }





}
