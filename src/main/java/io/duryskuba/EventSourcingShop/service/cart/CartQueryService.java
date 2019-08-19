package io.duryskuba.EventSourcingShop.service.cart;

import io.duryskuba.EventSourcingShop.exception.ResourceNotFoundException;
import io.duryskuba.EventSourcingShop.model.ShoppingCart;
import io.duryskuba.EventSourcingShop.repository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartQueryService {

    private final CartRepository cartRepository;

    public CartQueryService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }


    public Optional<ShoppingCart> findCartById(String id) {
        return cartRepository.findById(id);
    }

    public ShoppingCart findCartByIdOrThrow(String id) {
        return cartRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException(ShoppingCart.class, id));
    }
}
