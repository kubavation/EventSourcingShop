package io.duryskuba.EventSourcingShop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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

    @ManyToMany(mappedBy = "products")
    private List<ShoppingCart> shoppingCart;
}
