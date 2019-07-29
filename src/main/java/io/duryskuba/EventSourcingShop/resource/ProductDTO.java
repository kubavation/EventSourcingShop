package io.duryskuba.EventSourcingShop.resource;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ProductDTO {

    private String id;
    private String name;
    private String description;
    private String code;
    private String groupCode;
}
