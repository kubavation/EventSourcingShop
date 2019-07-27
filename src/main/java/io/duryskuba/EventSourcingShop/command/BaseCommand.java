package io.duryskuba.EventSourcingShop.command;

import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BaseCommand<T> {

    private T id;
}
