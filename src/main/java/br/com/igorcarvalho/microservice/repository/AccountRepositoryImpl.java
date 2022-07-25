package br.com.igorcarvalho.microservice.repository;

import br.com.igorcarvalho.microservice.model.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepositoryImpl extends AccountRepository, JpaRepository<AccountEntity, Long> {
    @Override
    default AccountEntity create(AccountEntity entity) {
        return save(entity);
    }

    @Override
    default Optional<AccountEntity> find(Long id) {
        return findById(id);
    }
}
