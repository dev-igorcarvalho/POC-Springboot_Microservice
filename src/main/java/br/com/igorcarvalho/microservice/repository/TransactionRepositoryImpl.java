package br.com.igorcarvalho.microservice.repository;

import br.com.igorcarvalho.microservice.model.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepositoryImpl extends TransactionRepository, JpaRepository<TransactionEntity, Long> {
    @Override
    default TransactionEntity create(TransactionEntity entity) {
        return this.save(entity);
    }
}
