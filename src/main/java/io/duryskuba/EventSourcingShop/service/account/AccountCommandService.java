package io.duryskuba.EventSourcingShop.service.account;

import io.duryskuba.EventSourcingShop.command.account.CreateAccountCommand;
import io.duryskuba.EventSourcingShop.command.account.ChangePasswordCommand;
import io.duryskuba.EventSourcingShop.resource.AccountDTO;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class AccountCommandService {

    private final CommandGateway commandGateway;

    public AccountCommandService(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    public CompletableFuture<String> createAccount(AccountDTO account) {
        return commandGateway.send (
                new CreateAccountCommand(
                        UUID.randomUUID().toString(), account.getUsername(),account.getPassword(), account.getEmail()
                )
            );
    }

    public CompletableFuture<String> changePassword(AccountDTO account) {
        return commandGateway.send(new ChangePasswordCommand(account.getId(), account.getPassword()));
    }

}
