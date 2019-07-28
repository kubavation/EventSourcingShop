package io.duryskuba.EventSourcingShop.controller;

import io.duryskuba.EventSourcingShop.service.AccountQueryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountQueryController {

    private final AccountQueryService accountQueryService;

    public AccountQueryController(AccountQueryService accountQueryService) {
        this.accountQueryService = accountQueryService;
    }


    @GetMapping("/accounts/{accId}/events")
    public List<Object> eventsOfAccount(@PathVariable String accId) {
        return accountQueryService.eventsOfAccount(accId);
    }
}
