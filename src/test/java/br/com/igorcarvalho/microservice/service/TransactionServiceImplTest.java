package br.com.igorcarvalho.microservice.service;

import br.com.igorcarvalho.microservice.mapper.Mapper;
import br.com.igorcarvalho.microservice.model.dto.TransactionDto;
import br.com.igorcarvalho.microservice.model.entity.TransactionEntity;
import br.com.igorcarvalho.microservice.repository.AccountRepository;
import br.com.igorcarvalho.microservice.repository.OperationTypeRepository;
import br.com.igorcarvalho.microservice.repository.TransactionRepository;
import br.com.igorcarvalho.microservice.util.ModelGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TransactionServiceImplTest {

    @Mock
    private Mapper mapper;
    @Mock
    private OperationTypeRepository operationTypeRepository;
    @Mock
    private AccountRepository accountRepository;
    @Mock
    private TransactionRepository transactionRepository;
    @InjectMocks
    private TransactionServiceImpl sut;
    private ModelGenerator generator = new ModelGenerator();

    @Test
    @DisplayName("Shoudl create a new transaction")
    void createNewTransaction_shoudl_return_a_valid_transaction() {
        when(operationTypeRepository.find(anyLong())).thenReturn(Optional.of(generator.operationTypeEntityGenerator()));
        when(accountRepository.find(anyLong())).thenReturn(Optional.of(generator.accountEntityGenerator()));
        when(transactionRepository.create(any(TransactionEntity.class))).thenReturn(generator.transactionEntityGenerator());
        when(mapper.toDto(any(TransactionEntity.class))).thenReturn(generator.transactionDtoGenerator());
        //when
        TransactionDto saved = sut.createNewTransaction(generator.postRequestGenerator());
        //then
        assertAll(
              () -> verify(transactionRepository).create(any(TransactionEntity.class)),
              () -> assertNotNull(saved),
              () -> assertNotNull(saved.getId()));
    }
}
