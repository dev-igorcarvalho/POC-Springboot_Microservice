package br.com.igorcarvalho.microservice.service;

import br.com.igorcarvalho.microservice.model.dto.TransactionDto;
import br.com.igorcarvalho.microservice.model.request.TransactionPostRequest;

public interface TransactionService {
    TransactionDto createNewTransaction(TransactionPostRequest dto);
}
