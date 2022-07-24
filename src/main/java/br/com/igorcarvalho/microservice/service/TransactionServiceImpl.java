package br.com.igorcarvalho.microservice.service;

import br.com.igorcarvalho.microservice.mapper.Mapper;
import br.com.igorcarvalho.microservice.model.dto.TransactionDto;
import br.com.igorcarvalho.microservice.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final Mapper mapper;

    private final TransactionRepository repository;

    public TransactionServiceImpl(@Qualifier("transactionMapper") Mapper mapper, TransactionRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public TransactionDto createNewTransaction(TransactionDto dto) {
        throw new java.lang.UnsupportedOperationException("Not implemented yet.");
    }
}
