package io.duryskuba.EventSourcingShop.command.cart;

import io.duryskuba.EventSourcingShop.command.BaseCommand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AddProductCommand extends BaseCommand<String> {

    private String productId;

    public AddProductCommand(String id, String productId) {
        super(id);
        this.productId = productId;
    }
}
