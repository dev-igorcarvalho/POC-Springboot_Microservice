package br.com.igorcarvalho.microservice.controller;

import br.com.igorcarvalho.microservice.model.dto.AccountDto;
import br.com.igorcarvalho.microservice.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(AccountController.ROUTE)
@RequiredArgsConstructor
public class AccountController {
    public static final String ROUTE = "api/v1/accounts";

    private final AccountService service;

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public AccountDto create(@RequestBody @Valid AccountDto request) {
        throw new java.lang.UnsupportedOperationException("Not implemented yet.");
    }

    @GetMapping(("/{accountId}"))
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public AccountDto get(@PathVariable Long accountId) {
        throw new java.lang.UnsupportedOperationException("Not implemented yet.");
    }
}
