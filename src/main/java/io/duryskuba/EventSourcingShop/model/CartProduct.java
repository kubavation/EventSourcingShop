package io.duryskuba.EventSourcingShop.model;

import lombok.AllArgsConstructor;
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

    private Long quantity;

    public CartProduct(CartProductId cartProductId, Long quantity) {
        this.cartProductId = cartProductId;
        this.quantity = quantity;
    }

    public CartProduct(Product product, ShoppingCart cart, Long quantity) {
        this.product = product;
        this.shoppingCart = cart;
        this.quantity = quantity;
    }
}
