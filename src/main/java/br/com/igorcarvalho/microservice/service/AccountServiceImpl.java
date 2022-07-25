package br.com.igorcarvalho.microservice.service;

import br.com.igorcarvalho.microservice.mapper.Mapper;
import br.com.igorcarvalho.microservice.model.dto.AccountDto;
import br.com.igorcarvalho.microservice.model.entity.AccountEntity;
import br.com.igorcarvalho.microservice.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;

@Service
public class AccountServiceImpl implements AccountService {
    private final Mapper mapper;
    private final AccountRepository repository;

    public AccountServiceImpl(@Qualifier("accountMapper") Mapper mapper, AccountRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    @Transactional
    public AccountDto createNewAccount(AccountDto dto) {
        AccountEntity entity = (AccountEntity) mapper.toEntity(dto);
        repository.create(entity);
        return (AccountDto) mapper.toDto(entity);
    }

    @Override
    public AccountDto getAccountById(Long accountId) {
        final AccountEntity entity = repository.find(accountId)
              .orElseThrow(() -> new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Account not found"));
        return (AccountDto) mapper.toDto(entity);
    }
}
