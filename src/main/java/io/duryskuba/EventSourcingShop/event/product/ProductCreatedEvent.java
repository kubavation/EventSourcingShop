package io.duryskuba.EventSourcingShop.event.product;

import io.duryskuba.EventSourcingShop.event.BaseEvent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductCreatedEvent extends BaseEvent<String> {
    private String name;
    private String code;
    private String description;
    private String groupCode;

    @Builder
    public ProductCreatedEvent(String id, String name, String code, String description, String groupCode) {
        super(id);
        this.name = name;
        this.code = code;
        this.description = description;
        this.groupCode = groupCode;
    }
}
