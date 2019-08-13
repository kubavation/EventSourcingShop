package io.duryskuba.EventSourcingShop.controller.cart;

import io.duryskuba.EventSourcingShop.resource.CartProductDTO;
import io.duryskuba.EventSourcingShop.service.cart.CartCommandService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
public class CartCommandController {

    private final CartCommandService cartCommandService;

    public CartCommandController(CartCommandService cartCommandService) {
        this.cartCommandService = cartCommandService;
    }

    @PostMapping("/carts/products")
    public CompletableFuture<String> addProduct(@RequestBody CartProductDTO dto) {
        return cartCommandService.addProduct(dto);
    }
}
