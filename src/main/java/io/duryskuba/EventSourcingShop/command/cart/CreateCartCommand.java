package io.duryskuba.EventSourcingShop.command.cart;

import io.duryskuba.EventSourcingShop.command.BaseCommand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateCartCommand extends BaseCommand<String> {

    private String accountId;

    public CreateCartCommand(String id, String accountId) {
        super(id);
        this.accountId = accountId;
    }
}
