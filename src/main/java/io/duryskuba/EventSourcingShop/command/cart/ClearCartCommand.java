package io.duryskuba.EventSourcingShop.command.cart;

import io.duryskuba.EventSourcingShop.command.BaseCommand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class ClearCartCommand extends BaseCommand<String> {

    public ClearCartCommand(String id) {
        super(id);
    }
}
