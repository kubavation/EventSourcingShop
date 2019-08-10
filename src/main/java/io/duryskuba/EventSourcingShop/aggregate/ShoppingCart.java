package io.duryskuba.EventSourcingShop.aggregate;

import io.duryskuba.EventSourcingShop.command.cart.AddProductCommand;
import io.duryskuba.EventSourcingShop.command.cart.CreateCartCommand;
import io.duryskuba.EventSourcingShop.enums.ShoppingCartStatus;
import io.duryskuba.EventSourcingShop.event.cart.CartCreatedEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.modelling.command.AggregateMember;
import org.axonframework.spring.stereotype.Aggregate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingCart {

    @AggregateIdentifier
    private String id;

    private String accountId;
    private ShoppingCartStatus shoppingCartStatus;
    private List<String> productIds;

    private LocalDateTime createdAt;


    @CommandHandler
    public ShoppingCart(CreateCartCommand cmd) {
        apply( new CartCreatedEvent(cmd.getId(), cmd.getAccountId()) );
    }

    @CommandHandler
    public void handle(AddProductCommand cmd) {
        apply( new ProductAddedEvent(cmd.getId(), cmd.getProductId()) );
    }

    @EventSourcingHandler
    public void on(CartCreatedEvent event) {
        this.id = event.getId();
        this.accountId = event.getAccountId();
        this.createdAt = LocalDateTime.now();
        this.productIds = new ArrayList<>();
        this.shoppingCartStatus = ShoppingCartStatus.ACTIVE;
    }

}
