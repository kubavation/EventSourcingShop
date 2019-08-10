package io.duryskuba.EventSourcingShop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.List;

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

    @ManyToMany(mappedBy = "products")
    private List<ShoppingCart> shoppingCart;
}
