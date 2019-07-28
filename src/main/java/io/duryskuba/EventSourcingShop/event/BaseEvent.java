package io.duryskuba.EventSourcingShop.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BaseEvent<T> {
    public T id;
}
