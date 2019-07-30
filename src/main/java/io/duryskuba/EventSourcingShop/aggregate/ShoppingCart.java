package io.duryskuba.EventSourcingShop.aggregate;

import io.duryskuba.EventSourcingShop.enums.ShoppingCartStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateMember;
import org.axonframework.spring.stereotype.Aggregate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
    

}
