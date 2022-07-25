package br.com.igorcarvalho.microservice.controller;

import br.com.igorcarvalho.microservice.model.dto.TransactionDto;
import br.com.igorcarvalho.microservice.model.request.TransactionPostRequest;
import br.com.igorcarvalho.microservice.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(TransactionController.ROUTE)
@RequiredArgsConstructor
public class TransactionController {
    public static final String ROUTE = "api/v1/transactions";

    private final TransactionService service;

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public TransactionDto create(@RequestBody @Valid TransactionPostRequest request) {
        return service.createNewTransaction(request);
    }

}
