package io.duryskuba.EventSourcingShop.command.cart;

import io.duryskuba.EventSourcingShop.command.BaseCommand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RemoveProductCommand extends BaseCommand<String> {

    private String productId;

    public RemoveProductCommand(String id, String productId) {
        super(id);
        this.productId = productId;
    }
}
