package io.duryskuba.EventSourcingShop.projection;

import io.duryskuba.EventSourcingShop.command.cart.CreateCartCommand;
import io.duryskuba.EventSourcingShop.event.account.AccountCreationEvent;
import io.duryskuba.EventSourcingShop.event.account.PasswordChangedEvent;
import io.duryskuba.EventSourcingShop.model.Account;
import io.duryskuba.EventSourcingShop.repository.AccountRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.messaging.responsetypes.MultipleInstancesResponseType;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Component
public class AccountProjection {

    private final AccountRepository accountRepository;
    private final CommandGateway commandGateway;

    public AccountProjection(AccountRepository accountRepository, CommandGateway commandGateway) {
        this.accountRepository = accountRepository;
        this.commandGateway = commandGateway;
    }

    @EventHandler
    public void on(AccountCreationEvent event) {
        System.out.println(event);
        accountRepository.save(
                new Account(event.getId(), event.getUsername(), event.getPassword(), event.getEmail(), LocalDateTime.now())
        );

        //commandGateway.send( new CreateCartCommand(UUID.randomUUID().toString(), event.getId()));
    }

    @EventHandler
    public void on(PasswordChangedEvent event) {
        System.out.println(event);
        accountRepository.findById(event.getId())
                .map(a -> {
                    a.setPassword(event.getPassword());
                    return a;
                });
    }



}
