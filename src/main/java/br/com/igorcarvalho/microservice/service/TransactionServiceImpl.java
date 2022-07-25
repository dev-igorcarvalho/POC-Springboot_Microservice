package br.com.igorcarvalho.microservice.service;

import br.com.igorcarvalho.microservice.mapper.Mapper;
import br.com.igorcarvalho.microservice.model.dto.TransactionDto;
import br.com.igorcarvalho.microservice.model.entity.AccountEntity;
import br.com.igorcarvalho.microservice.model.entity.OperationTypeEntity;
import br.com.igorcarvalho.microservice.model.entity.TransactionEntity;
import br.com.igorcarvalho.microservice.model.request.TransactionPostRequest;
import br.com.igorcarvalho.microservice.repository.AccountRepository;
import br.com.igorcarvalho.microservice.repository.OperationTypeRepository;
import br.com.igorcarvalho.microservice.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final Mapper mapper;

    private final OperationTypeRepository operationTypeRepository;
    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    public TransactionServiceImpl(@Qualifier("transactionMapper") Mapper mapper, TransactionRepository repository, OperationTypeRepository operationTypeRepository, AccountRepository accountRepository, TransactionRepository transactionRepository) {
        this.mapper = mapper;
        this.operationTypeRepository = operationTypeRepository;
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    @Transactional
    public TransactionDto createNewTransaction(TransactionPostRequest request) {
        final TransactionEntity entity = this.generateTransaction(request);
        transactionRepository.create(entity);
        return (TransactionDto) mapper.toDto(entity);
    }

    private TransactionEntity generateTransaction(TransactionPostRequest request) {
        final AccountEntity account = accountRepository.find(request.getAccountId())
              .orElseThrow(() -> new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Account not found"));
        final OperationTypeEntity operationType = operationTypeRepository.find(request.getOperationTypeId())
              .orElseThrow(() -> new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Operation type not found"));
        final BigDecimal calculatedAmount =
              generateAmountBasedOnOperationType(request.getAmount(), operationType.getDscription());
        return TransactionEntity.builder()
              .operationType(operationType)
              .account(account)
              .eventDate(LocalDateTime.now())
              .amount(calculatedAmount)
              .build();
    }

    private BigDecimal generateAmountBasedOnOperationType(Double value, String operationType) {
        final String positiveAmountOperationType = "PAGAMENTO";
        if (!operationType.equalsIgnoreCase(positiveAmountOperationType)) {
            return new BigDecimal(value).negate();
        }
        return new BigDecimal(value);
    }
}
