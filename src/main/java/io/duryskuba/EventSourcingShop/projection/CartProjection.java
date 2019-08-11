package io.duryskuba.EventSourcingShop.projection;

import io.duryskuba.EventSourcingShop.repository.CartProductRepository;
import io.duryskuba.EventSourcingShop.repository.CartRepository;
import org.springframework.stereotype.Component;

@Component
public class CartProjection {

    private final CartRepository cartRepository;
    private final CartProductRepository cartProductRepository;

    public CartProjection(CartRepository cartRepository, CartProductRepository cartProductRepository) {
        this.cartRepository = cartRepository;
        this.cartProductRepository = cartProductRepository;
    }

    //todo + tworzenie shoppingcart

    
}
