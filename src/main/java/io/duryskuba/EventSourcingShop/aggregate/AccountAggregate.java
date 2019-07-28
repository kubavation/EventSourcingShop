package io.duryskuba.EventSourcingShop.aggregate;

import io.duryskuba.EventSourcingShop.command.account.AccountCreationCommand;
import io.duryskuba.EventSourcingShop.event.account.AccountCreationEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.time.LocalDateTime;

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
    public AccountAggregate(AccountCreationCommand cmd) {
        apply(new AccountCreationEvent(
                cmd.getId(), cmd.getUsername(), cmd.getPassword(), cmd.getEmail()) );
    }


    @EventSourcingHandler
    protected void on(AccountCreationEvent event) {
        this.id = event.getId();
        this.username = event.getUsername();
        this.password = event.getPassword();
        this.email = event.getEmail();
        this.createdAt = LocalDateTime.now();
    }
}


