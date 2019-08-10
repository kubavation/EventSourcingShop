package io.duryskuba.EventSourcingShop.command.cart;

import io.duryskuba.EventSourcingShop.event.BaseEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductRemovedEvent extends BaseEvent<String> {

    private String productId;

    public ProductRemovedEvent(String id, String productId) {
        super(id);
        this.productId = productId;
    }
}
