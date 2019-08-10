package io.duryskuba.EventSourcingShop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ShoppingCart {

    @Id
    private String id;

    @OneToOne(mappedBy = "shoppingCart")
    private Account account;

    @ManyToMany
    @JoinTable(
        name = "CART_PRODUCT",
        joinColumns = { @JoinColumn(name = "cart_id") },
        inverseJoinColumns = { @JoinColumn(name = "product_id") }
    )
    private List<Product> products;
}
