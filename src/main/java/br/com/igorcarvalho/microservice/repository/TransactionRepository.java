package br.com.igorcarvalho.microservice.repository;

import br.com.igorcarvalho.microservice.model.entity.TransactionEntity;

public interface TransactionRepository {
    TransactionEntity save(TransactionEntity entity);
}
