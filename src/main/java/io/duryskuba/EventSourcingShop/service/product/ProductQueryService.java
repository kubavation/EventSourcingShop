package io.duryskuba.EventSourcingShop.service.product;

import io.duryskuba.EventSourcingShop.model.Product;
import io.duryskuba.EventSourcingShop.repository.ProductRepository;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProductQueryService {

    private final ProductRepository productRepository;

    public ProductQueryService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @QueryHandler(queryName = "findAllProducts")
    public Iterable<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @QueryHandler(queryName = "findProductById")
    public Optional<Product> findProductById(String id) {
        return productRepository.findById(id);
    }
}
