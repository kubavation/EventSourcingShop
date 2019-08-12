package io.duryskuba.EventSourcingShop.controller.product;

import io.duryskuba.EventSourcingShop.resource.ProductDTO;
import io.duryskuba.EventSourcingShop.service.product.ProductCommandService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
public class ProductCommandController {

    private ProductCommandService productCommandService;

    public ProductCommandController(ProductCommandService productCommandService) {
        this.productCommandService = productCommandService;
    }

//    @PostMapping("/products")
//    public CompletableFuture<String> createProduct(@RequestBody ProductDTO productDTO) {
//        return productCommandService.createProduct(productDTO);
//    }

    @PostMapping("/products")
    public ResponseEntity<Void> createProduct(@RequestBody ProductDTO productDTO) {
        productCommandService.createProduct(productDTO);
        return ResponseEntity.ok().build();
    }
}
