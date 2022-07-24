package br.com.igorcarvalho.microservice.repository;

import br.com.igorcarvalho.microservice.model.entity.AccountEntity;

import java.util.Optional;

public interface AccountRepository {
    AccountEntity save(AccountEntity entity);

    Optional<AccountEntity> find(Long id);
}
