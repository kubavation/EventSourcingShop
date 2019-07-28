package io.duryskuba.EventSourcingShop.service;

import io.duryskuba.EventSourcingShop.command.account.AccountCreationCommand;
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
                new AccountCreationCommand(
                        UUID.randomUUID().toString(), account.getUsername(),account.getPassword(), account.getEmail()
                )
            );
    }

}
