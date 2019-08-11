package io.duryskuba.EventSourcingShop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Embeddable
public class CartProductId implements Serializable {

    @Column(name = "PRODUCT_ID")
    private String productId;
    @Column(name = "CART_ID")
    private String cartId;
}
