package io.duryskuba.EventSourcingShop.event.cart;


import io.duryskuba.EventSourcingShop.event.BaseEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductAddedEvent extends BaseEvent<String> {

    private String productId;

    public ProductAddedEvent(String id, String productId) {
        super(id);
        this.productId = productId;
    }
}
