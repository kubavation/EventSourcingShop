package io.duryskuba.EventSourcingShop.event.cart;

import io.duryskuba.EventSourcingShop.event.BaseEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CartCreatedEvent extends BaseEvent<String> {

    private String accountId;

    public CartCreatedEvent(String id, String accountId) {
        super(id);
        this.accountId = accountId;
    }
}
