package io.duryskuba.EventSourcingShop.resource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AccountDTO {

    private String id;
    private String username;
    private String password;
    private String email;
}
