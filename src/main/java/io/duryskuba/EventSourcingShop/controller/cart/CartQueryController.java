package io.duryskuba.EventSourcingShop.controller.cart;

import io.duryskuba.EventSourcingShop.model.ShoppingCart;
import io.duryskuba.EventSourcingShop.service.cart.CartQueryService;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
public class CartQueryController {

    private final CartQueryService cartQueryService;
    private final QueryGateway queryGateway;

    public CartQueryController(CartQueryService cartQueryService, QueryGateway queryGateway) {
        this.cartQueryService = cartQueryService;
        this.queryGateway = queryGateway;
    }

    @GetMapping("/carts")
    public CompletableFuture<List<ShoppingCart>> findAllCarts() {
        return queryGateway.query("findAllCarts",null, ResponseTypes.multipleInstancesOf(ShoppingCart.class));
    }

    @GetMapping("/carts/{cartId}/products")
    public ShoppingCart findCartById(String cartId) {
        return cartQueryService.findCartByIdOrThrow(cartId);
    }


    @GetMapping("/carts/{id}/events")
    public List<Object> eventsOfCart(@PathVariable String id) {
        return cartQueryService.eventsOfCart(id);
    }

}
