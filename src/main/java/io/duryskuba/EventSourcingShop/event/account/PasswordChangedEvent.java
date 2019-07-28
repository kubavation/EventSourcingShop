package io.duryskuba.EventSourcingShop.event.account;

import io.duryskuba.EventSourcingShop.event.BaseEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PasswordChangedEvent extends BaseEvent<String> {

    private String password;

    public PasswordChangedEvent(String id, String password) {
        super(id);
        this.password = password;
    }
}
