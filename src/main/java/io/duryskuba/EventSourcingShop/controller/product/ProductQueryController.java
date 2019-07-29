package io.duryskuba.EventSourcingShop.controller.product;

import io.duryskuba.EventSourcingShop.model.Product;
import io.duryskuba.EventSourcingShop.service.product.ProductQueryService;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
public class ProductQueryController {

    private final QueryGateway queryGateway;

    public ProductQueryController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    @GetMapping("/products")
    public CompletableFuture<List<Product>> findAll() {
        return queryGateway.query("findAllProducts",null, ResponseTypes.multipleInstancesOf(Product.class) );
    }
}
