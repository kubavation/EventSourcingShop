package io.duryskuba.EventSourcingShop.aggregate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.List;

@Aggregate
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingCart {

    @AggregateIdentifier
    private String id;

    private List<ProductAggregate> products;
}
