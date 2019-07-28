package io.duryskuba.EventSourcingShop.command;

import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
import org.springframework.web.bind.annotation.GetMapping;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BaseCommand<T> {

    @TargetAggregateIdentifier
    private T id;
}
