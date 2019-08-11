package io.duryskuba.EventSourcingShop.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.concurrent.atomic.AtomicLong;

@Entity
@Table(name = "CART_PRODUCT")
@Data
@NoArgsConstructor
public class CartProduct {

    @EmbeddedId
    private CartProductId cartProductId;

    @ManyToOne
    @MapsId("cartId")
    @JoinColumn(name = "CART_ID")
    private ShoppingCart shoppingCart;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    private AtomicLong quantity;
}