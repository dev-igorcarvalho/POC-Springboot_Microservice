package br.com.igorcarvalho.microservice.repository;

import br.com.igorcarvalho.microservice.model.entity.OperationTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OperationTypeRepositoryImpl extends OperationTypeRepository, JpaRepository<OperationTypeEntity, Long> {

    @Override
    default Optional<OperationTypeEntity> find(Long id) {
        return findById(id);
    }
}
