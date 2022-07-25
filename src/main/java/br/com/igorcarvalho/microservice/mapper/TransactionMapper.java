package br.com.igorcarvalho.microservice.mapper;

import br.com.igorcarvalho.microservice.model.dto.OperationTypeDto;
import br.com.igorcarvalho.microservice.model.dto.TransactionDto;
import br.com.igorcarvalho.microservice.model.entity.OperationTypeEntity;
import br.com.igorcarvalho.microservice.model.entity.TransactionEntity;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Qualifier("transactionMapper")
public class TransactionMapper implements Mapper<TransactionEntity, TransactionDto> {
    @Override
    public TransactionEntity toEntity(TransactionDto dto) {
        return TransactionEntity.builder()
              .id(dto.getId())
              .amount(dto.getAmount())
              .eventDate(dto.getEventDate())
              .operationType(new OperationTypeEntity(dto.getOperationTypeDto().getId()
                    , dto.getOperationTypeDto().getDescription()))
              .build();
    }

    @Override
    public TransactionDto toDto(TransactionEntity entity) {
        return TransactionDto.builder()
              .id(entity.getId())
              .amount(entity.getAmount())
              .eventDate(entity.getEventDate())
              .operationTypeDto(
                    new OperationTypeDto(entity.getOperationType().getId(),
                          entity.getOperationType().getDscription()))
              .build();
    }

    @Override
    public List<TransactionEntity> toEntity(List<TransactionDto> dtos) {
        List<TransactionEntity> result = dtos.stream().map(e -> this.toEntity(e)).collect(Collectors.toList());
        return result;
    }

    @Override
    public List<TransactionDto> toDto(List<TransactionEntity> entities) {
        List<TransactionDto> result = entities.stream().map(e -> this.toDto(e)).collect(Collectors.toList());
        return result;
    }
}
