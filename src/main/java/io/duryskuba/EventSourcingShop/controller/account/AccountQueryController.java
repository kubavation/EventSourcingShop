package io.duryskuba.EventSourcingShop.controller.account;

import io.duryskuba.EventSourcingShop.model.Account;
import io.duryskuba.EventSourcingShop.model.ShoppingCart;
import io.duryskuba.EventSourcingShop.repository.CartRepository;
import io.duryskuba.EventSourcingShop.service.account.AccountQueryService;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
public class AccountQueryController {

    private final AccountQueryService accountQueryService;
    private final QueryGateway queryGateway;

    public AccountQueryController(AccountQueryService accountQueryService, QueryGateway queryGateway) {
        this.accountQueryService = accountQueryService;
        this.queryGateway = queryGateway;
    }

    @GetMapping("/accounts/{accId}/events")
    public List<Object> eventsOfAccount(@PathVariable String accId) {
        return accountQueryService.eventsOfAccount(accId);
    }

    @GetMapping("/accounts")
    public CompletableFuture<List<Account>> findAll() {
       return queryGateway.query("findAll", null, ResponseTypes.multipleInstancesOf(Account.class) );
    }

}
