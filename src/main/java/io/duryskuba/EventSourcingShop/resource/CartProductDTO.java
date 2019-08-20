package io.duryskuba.EventSourcingShop.resource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CartProductDTO {

    private String cartId;
    private String productId;
    private Long quantity;
}
