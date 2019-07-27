package io.duryskuba.EventSourcingShop.event.account;

import io.duryskuba.EventSourcingShop.event.BaseEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AccountCreationEvent extends BaseEvent<String> {

    private String username;
    private String password;
    private String email;

}
