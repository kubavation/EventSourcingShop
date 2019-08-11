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

    @OneToMany(mappedBy = "shoppingCart")
    private List<CartProduct> cartProducts;
}
