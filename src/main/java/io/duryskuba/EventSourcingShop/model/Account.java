package io.duryskuba.EventSourcingShop.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonIdentityInfo(
    generator = ObjectIdGenerators.PropertyGenerator.class,
    property = "id"
)
public class Account {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String username;
    private String password;
    private String email;
    private LocalDateTime createdAt;

    @OneToOne(mappedBy = "account")
    private ShoppingCart shoppingCart;

    public Account(String id, String username, String password, String email, LocalDateTime now) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.createdAt = now;
    }
}
