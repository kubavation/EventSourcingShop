package io.duryskuba.EventSourcingShop.aggregate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import java.time.LocalDateTime;

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



}


