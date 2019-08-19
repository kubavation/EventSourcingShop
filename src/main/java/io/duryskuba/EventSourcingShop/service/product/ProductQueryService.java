package io.duryskuba.EventSourcingShop.service.product;

import io.duryskuba.EventSourcingShop.exception.ResourceNotFoundException;
import io.duryskuba.EventSourcingShop.model.Product;
import io.duryskuba.EventSourcingShop.repository.ProductRepository;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import java.util.Collection;
import java.util.Optional;

@Component
public class ProductQueryService {

    private final ProductRepository productRepository;

    public ProductQueryService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @QueryHandler(queryName = "findAllProducts")
    public Collection<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> findProductById(String id) {
        return productRepository.findById(id);
    }

    public Product findProductByIdOrThrow(String id) {
        return productRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException(Product.class, id));
    }
}
