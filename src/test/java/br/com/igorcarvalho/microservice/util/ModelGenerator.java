package br.com.igorcarvalho.microservice.util;

import br.com.igorcarvalho.microservice.model.dto.AccountDto;
import br.com.igorcarvalho.microservice.model.dto.OperationTypeDto;
import br.com.igorcarvalho.microservice.model.dto.TransactionDto;
import br.com.igorcarvalho.microservice.model.entity.AccountEntity;
import br.com.igorcarvalho.microservice.model.entity.OperationTypeEntity;
import br.com.igorcarvalho.microservice.model.entity.TransactionEntity;
import br.com.igorcarvalho.microservice.model.request.TransactionPostRequest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ModelGenerator {
    public AccountEntity accountEntityGenerator() {
        return AccountEntity.builder().id(1L).documentNumber("12345678900")
              .transactions(new ArrayList<>()).build();
    }

    public AccountDto accountDtoGenerator() {
        return AccountDto.builder().id(1L).documentNumber("12345678900")
              .transactions(new ArrayList<>()).build();
    }

    public TransactionEntity transactionEntityGenerator() {
        return TransactionEntity.builder()
              .id(1l)
              .eventDate(LocalDateTime.now())
              .amount(new BigDecimal(123.12))
              .operationType(operationTypeEntityGenerator())
              .account(this.accountEntityGenerator()).build();
    }

    public TransactionDto transactionDtoGenerator() {
        return TransactionDto.builder()
              .id(1l)
              .eventDate(LocalDateTime.now())
              .amount(new BigDecimal(123.12))
              .operationTypeDto(operationTypeDtoGenerator())
              .build();
    }

    public TransactionPostRequest postRequestGenerator() {
        return new TransactionPostRequest(1l, 1l, 123.22);
    }

    public OperationTypeEntity operationTypeEntityGenerator() {
        return new OperationTypeEntity(1l, "any");
    }

    public OperationTypeDto operationTypeDtoGenerator() {
        return new OperationTypeDto(1l, "any");
    }
}
