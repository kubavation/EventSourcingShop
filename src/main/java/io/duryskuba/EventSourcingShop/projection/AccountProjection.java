package io.duryskuba.EventSourcingShop.projection;

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

@Component
public class AccountProjection {

    private final AccountRepository accountRepository;

    @Autowired
    private CommandGateway commandGateway;

    public AccountProjection(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    @EventHandler
    public void on(AccountCreationEvent event) {
        System.out.println(event);
        accountRepository.save(
                new Account(event.getId(), event.getUsername(), event.getPassword(), event.getEmail(), LocalDateTime.now())
        );
        //command gateway ( create cart command )
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
