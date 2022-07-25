package br.com.igorcarvalho.microservice.repository;

import br.com.igorcarvalho.microservice.model.entity.OperationTypeEntity;

import java.util.Optional;

public interface OperationTypeRepository {
    Optional<OperationTypeEntity> find(Long id);
}
