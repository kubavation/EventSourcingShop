package io.duryskuba.EventSourcingShop.command.account;

import io.duryskuba.EventSourcingShop.command.BaseCommand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ChangePasswordCommand extends BaseCommand<String> {

    private String password;

    public ChangePasswordCommand(String id, String password) {
        super(id);
        this.password = password;
    }
}
