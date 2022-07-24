package br.com.igorcarvalho.microservice.mapper;

import br.com.igorcarvalho.microservice.model.dto.TransactionDto;
import br.com.igorcarvalho.microservice.model.entity.TransactionEntity;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Qualifier("transactionMapper")
public class TransactionMapper implements Mapper<TransactionEntity, TransactionDto> {
    @Override
    public TransactionEntity toEntity(TransactionDto transactionDto) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public TransactionDto toDto(TransactionEntity transactionEntity) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public List<TransactionEntity> toEntity(List<TransactionDto> transactionDtos) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public List<TransactionDto> toDto(List<TransactionEntity> transactionEntities) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }
}
