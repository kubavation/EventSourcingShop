package io.duryskuba.EventSourcingShop.projection;

import io.duryskuba.EventSourcingShop.event.cart.CartCreatedEvent;
import io.duryskuba.EventSourcingShop.event.cart.ProductAddedEvent;
import io.duryskuba.EventSourcingShop.exception.ResourceNotFoundException;
import io.duryskuba.EventSourcingShop.model.*;
import io.duryskuba.EventSourcingShop.repository.CartProductRepository;
import io.duryskuba.EventSourcingShop.repository.CartRepository;
import io.duryskuba.EventSourcingShop.service.account.AccountQueryService;
import io.duryskuba.EventSourcingShop.service.product.ProductQueryService;
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
    private final ProductQueryService productQueryService;
    private final AccountQueryService accountQueryService;

    public CartProjection(CartRepository cartRepository, CartProductRepository cartProductRepository,
                          QueryGateway queryGateway, ProductQueryService productQueryService,
                          AccountQueryService accountQueryService) {
        this.cartRepository = cartRepository;
        this.cartProductRepository = cartProductRepository;
        this.queryGateway = queryGateway;
        this.productQueryService = productQueryService;
        this.accountQueryService = accountQueryService;
    }

    //todo + tworzenie shoppingcart

    @EventHandler
    public void on(CartCreatedEvent event) throws Exception {

        System.out.println("ON CART CREATED EVENT - PROJECTION");

        Account account = queryGateway.query("findAll",null,ResponseTypes.multipleInstancesOf(Account.class))
                .thenApply(list -> list.stream()
                        .filter(a -> a.getId().equals(event.getAccountId()))
                        .findFirst())
                .get()
                .orElseThrow(RuntimeException::new);

        if (account.getShoppingCart() == null)
            cartRepository.save( new ShoppingCart(event.getId(), account) );
    }

    @EventHandler
    public void on(ProductAddedEvent event) throws Exception {

        Product product = pro
    }

//        Product product = queryGateway.query("findAllProducts", null, ResponseTypes.multipleInstancesOf(Product.class))
//                .thenApply(list -> list.stream()
//                     .filter(p -> p.getId().equals(event.getProductId())).findFirst())
//                .get()
//                    .orElseThrow(() -> new ResourceNotFoundException(Product.class));
//
//        ShoppingCart cart = cartRepository.findById(event.getId())
//                .orElseThrow(() -> new ResourceNotFoundException(ShoppingCart.class));
//
//        CartProduct cartProduct = new CartProduct();
//        cartProduct.setProduct(product);
//        cartProduct.setShoppingCart(cart);
//        cartProduct.setQuantity(1L); //tests
//
//        cartProductRepository.save(cartProduct);
//        System.out.println("saved");



}
