package io.duryskuba.EventSourcingShop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Product {

    @Id
    private String id;

    private String name;
    private String description;
    private String code;
    private String groupCode;

    private AtomicLong quantity;
    private BigDecimal price;

    private LocalDateTime addedAt;

    @OneToMany(mappedBy = "product")
    private List<CartProduct> cartProducts;
}
