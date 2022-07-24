package br.com.igorcarvalho.microservice.service;

import br.com.igorcarvalho.microservice.mapper.Mapper;
import br.com.igorcarvalho.microservice.model.dto.AccountDto;
import br.com.igorcarvalho.microservice.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    private final Mapper mapper;
    private final AccountRepository repository;

    public AccountServiceImpl(@Qualifier("accountMapper") Mapper mapper, AccountRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public AccountDto createNewAccount(AccountDto dto) {
        throw new java.lang.UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public AccountDto getAccountById(Long accountId) {
        throw new java.lang.UnsupportedOperationException("Not implemented yet.");
    }
}
