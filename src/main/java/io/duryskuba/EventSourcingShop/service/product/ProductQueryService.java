package io.duryskuba.EventSourcingShop.service.product;

import io.duryskuba.EventSourcingShop.model.Product;
import io.duryskuba.EventSourcingShop.repository.ProductRepository;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

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
}
