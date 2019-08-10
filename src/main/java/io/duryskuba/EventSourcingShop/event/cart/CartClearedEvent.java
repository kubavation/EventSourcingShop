package io.duryskuba.EventSourcingShop.event.cart;

import io.duryskuba.EventSourcingShop.event.BaseEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CartClearedEvent extends BaseEvent<String> {

    public CartClearedEvent(String id) {
        super(id);
    }
}
