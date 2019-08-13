package io.duryskuba.EventSourcingShop.resource;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicLong;

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

    private BigDecimal price;
    private Long quantity;

}
