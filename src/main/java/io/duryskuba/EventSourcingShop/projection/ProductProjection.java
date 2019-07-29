package io.duryskuba.EventSourcingShop.projection;

import io.duryskuba.EventSourcingShop.event.product.ProductCreatedEvent;
import io.duryskuba.EventSourcingShop.model.Product;
import io.duryskuba.EventSourcingShop.repository.ProductRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@Component
public class ProductProjection {

    private final ProductRepository productRepository;

    public ProductProjection(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @EventHandler
    public void on(ProductCreatedEvent event) {
        productRepository.save(
                Product.builder()
                    .id(event.getId())
                    .name(event.getName())
                    .code(event.getCode())
                    .description(event.getDescription())
                    .groupCode(event.getGroupCode()).build() );
    }
}
