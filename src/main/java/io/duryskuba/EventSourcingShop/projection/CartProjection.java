package io.duryskuba.EventSourcingShop.projection;

import io.duryskuba.EventSourcingShop.event.cart.ProductAddedEvent;
import io.duryskuba.EventSourcingShop.model.Product;
import io.duryskuba.EventSourcingShop.repository.CartProductRepository;
import io.duryskuba.EventSourcingShop.repository.CartRepository;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.concurrent.ExecutionException;

@Component
public class CartProjection {

    private final CartRepository cartRepository;
    private final CartProductRepository cartProductRepository;
    private final QueryGateway queryGateway;

    public CartProjection(CartRepository cartRepository, CartProductRepository cartProductRepository, QueryGateway queryGateway) {
        this.cartRepository = cartRepository;
        this.cartProductRepository = cartProductRepository;
        this.queryGateway = queryGateway;
    }

    //todo + tworzenie shoppingcart

    @EventHandler
    public void on(ProductAddedEvent event) throws Exception {
        Product product = queryGateway.query("ProductAddedEvent", null, ResponseTypes.multipleInstancesOf(Product.class))
                .thenApply(list -> list.stream()
                .filter(p -> p.getId().equals(event.getProductId())).findFirst())
                .get()
                .orElseThrow(RuntimeException::new);

        // + getting shopcart
    }

}
