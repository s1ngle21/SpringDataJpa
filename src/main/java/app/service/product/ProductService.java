package app.service.product;

import app.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Optional<Product> getById(Long id);
    List<Product> getAll();
    Product add(Product product);
    void delete(Long id);
}
