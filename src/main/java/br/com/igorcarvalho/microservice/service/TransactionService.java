package br.com.igorcarvalho.microservice.service;

import br.com.igorcarvalho.microservice.model.dto.TransactionDto;

public interface TransactionService {
    TransactionDto createNewTransaction(TransactionDto dto);
}
