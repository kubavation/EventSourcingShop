package io.duryskuba.EventSourcingShop.command.product;

import io.duryskuba.EventSourcingShop.command.BaseCommand;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateProductCommand extends BaseCommand<String> {

    private String name;
    private String code;
    private String description;
    private String groupCode;

    @Builder
    public CreateProductCommand(String id, String name, String code, String description, String groupCode) {
        super(id);
        this.name = name;
        this.code = code;
        this.description = description;
        this.groupCode = groupCode;
    }
}
