package io.duryskuba.EventSourcingShop.command.account;

import io.duryskuba.EventSourcingShop.command.BaseCommand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AccountCreationCommand extends BaseCommand<String> {

    private String username;
    private String password;
    private String email;

}
