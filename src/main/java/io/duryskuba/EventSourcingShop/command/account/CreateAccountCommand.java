package io.duryskuba.EventSourcingShop.command.account;

import io.duryskuba.EventSourcingShop.command.BaseCommand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateAccountCommand extends BaseCommand<String> {

    private String username;
    private String password;
    private String email;


    public CreateAccountCommand(String id, String username, String password, String email) {
        super(id);
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
