package io.duryskuba.EventSourcingShop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ShoppingCart {

    @Id
    private String id;

    @OneToOne(mappedBy = "shoppingCart")
    private Account account;
    
}
