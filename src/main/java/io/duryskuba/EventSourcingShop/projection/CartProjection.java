package io.duryskuba.EventSourcingShop.projection;

import io.duryskuba.EventSourcingShop.event.cart.ProductAddedEvent;
import io.duryskuba.EventSourcingShop.model.CartProduct;
import io.duryskuba.EventSourcingShop.model.CartProductId;
import io.duryskuba.EventSourcingShop.model.Product;
import io.duryskuba.EventSourcingShop.model.ShoppingCart;
import io.duryskuba.EventSourcingShop.repository.CartProductRepository;
import io.duryskuba.EventSourcingShop.repository.CartRepository;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicLong;

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

//        Product product = queryGateway.query("findAllProducts", null, ResponseTypes.multipleInstancesOf(Product.class))
//                .thenApply(list -> list.stream()
//                     .filter(p -> p.getId().equals(event.getProductId())).findFirst())
//                .get()
//                .orElseThrow(RuntimeException::new);
//
//        ShoppingCart cart = cartRepository.findById(event.getId())
//                .orElseThrow(RuntimeException::new);

        System.out.println("product added");
        cartProductRepository.save(
                new CartProduct(new CartProductId(event.getId(), event.getProductId()), new AtomicLong(1)) );
    }

}
