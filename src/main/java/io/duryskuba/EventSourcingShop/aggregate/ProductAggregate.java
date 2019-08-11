package io.duryskuba.EventSourcingShop.aggregate;


import io.duryskuba.EventSourcingShop.command.product.CreateProductCommand;
import io.duryskuba.EventSourcingShop.event.product.ProductCreatedEvent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductAggregate {

    @AggregateIdentifier
    private String id;

    private String name;
    private String code;
    private String description;

    private String groupCode;


    @CommandHandler
    public ProductAggregate(CreateProductCommand cmd) {
        apply( ProductCreatedEvent.builder()
                    .id(cmd.getId())
                    .name(cmd.getName())
                    .description(cmd.getDescription())
                    .groupCode(cmd.getGroupCode())
                    .code(cmd.getCode()).build() );
    }


    @EventSourcingHandler
    protected void on(ProductCreatedEvent event) {
        this.id = event.getId();
        this.name = event.getName();
        this.description = event.getDescription();
        this.code = event.getCode();
        this.groupCode = event.getGroupCode();
    }



}
