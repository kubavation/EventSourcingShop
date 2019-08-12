package io.duryskuba.EventSourcingShop.aggregate;

import io.duryskuba.EventSourcingShop.command.account.CreateAccountCommand;
import io.duryskuba.EventSourcingShop.command.account.ChangePasswordCommand;
import io.duryskuba.EventSourcingShop.command.cart.CreateCartCommand;
import io.duryskuba.EventSourcingShop.event.account.AccountCreationEvent;
import io.duryskuba.EventSourcingShop.event.account.PasswordChangedEvent;
import io.duryskuba.EventSourcingShop.event.cart.CartCreatedEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountAggregate {

    @AggregateIdentifier
    private String id;

    private String username;
    private String password;
    private String email;

    private LocalDateTime createdAt;


    @CommandHandler
    public AccountAggregate(CreateAccountCommand cmd) {
        apply(new AccountCreationEvent(
                cmd.getId(), cmd.getUsername(), cmd.getPassword(), cmd.getEmail()) );
    }

    @CommandHandler
    public void handle(ChangePasswordCommand cmd) {
        apply(new PasswordChangedEvent(cmd.getId(), cmd.getPassword()));
    }


    @EventSourcingHandler
    protected void on(AccountCreationEvent event) {
        this.id = event.getId();
        this.username = event.getUsername();
        this.password = event.getPassword();
        this.email = event.getEmail();
        this.createdAt = LocalDateTime.now();

        apply(new CartCreatedEvent(UUID.randomUUID().toString(), event.getId()));
    }

    @EventSourcingHandler
    protected void on(PasswordChangedEvent event) {
        this.password = event.getPassword();
    }
}


