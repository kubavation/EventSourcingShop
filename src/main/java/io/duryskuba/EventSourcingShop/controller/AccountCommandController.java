package io.duryskuba.EventSourcingShop.controller;

import io.duryskuba.EventSourcingShop.resource.AccountDTO;
import io.duryskuba.EventSourcingShop.service.AccountCommandService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
public class AccountCommandController {

    private final AccountCommandService accountCommandService;

    public AccountCommandController(AccountCommandService accountCommandService) {
        this.accountCommandService = accountCommandService;
    }


    @PostMapping("/accounts")
    public CompletableFuture<String> createAccount(@RequestBody AccountDTO accountDTO) {
        return accountCommandService.createAccount(accountDTO);
    }
}
