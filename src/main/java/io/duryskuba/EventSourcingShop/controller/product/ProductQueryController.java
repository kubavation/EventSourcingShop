package io.duryskuba.EventSourcingShop.controller.product;

import io.duryskuba.EventSourcingShop.model.Product;
import io.duryskuba.EventSourcingShop.service.product.ProductQueryService;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
public class ProductQueryController {

    private final QueryGateway queryGateway;
    private final ProductQueryService productQueryService;

    public ProductQueryController(QueryGateway queryGateway, ProductQueryService productQueryService) {
        this.queryGateway = queryGateway;
        this.productQueryService = productQueryService;
    }

    @GetMapping("/products")
    public CompletableFuture<List<Product>> findAll() {
        return queryGateway.query("findAllProducts",null, ResponseTypes.multipleInstancesOf(Product.class) );
    }

    @GetMapping("/products/{id}")
    public Product findProductById(@PathVariable String id) {
        return productQueryService.findProductByIdOrThrow(id);
    }
}
