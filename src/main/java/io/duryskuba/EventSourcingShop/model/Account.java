package io.duryskuba.EventSourcingShop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Account {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String username;
    private String password;
    private String email;
    private LocalDateTime createdAt;

    @OneToOne
    @JoinColumn(name = "cart_id")
    private ShoppingCart shoppingCart;
}
