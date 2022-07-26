package br.com.igorcarvalho.microservice.service;

import br.com.igorcarvalho.microservice.mapper.Mapper;
import br.com.igorcarvalho.microservice.model.dto.AccountDto;
import br.com.igorcarvalho.microservice.model.entity.AccountEntity;
import br.com.igorcarvalho.microservice.repository.AccountRepository;
import br.com.igorcarvalho.microservice.util.ModelGenerator;
import org.junit.jupiter.api.BeforeEach;
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
import static org.mockito.BDDMockito.when;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@DisplayName("Account service test")
class AccountServiceImplTest {

    @Mock
    private Mapper mapper;
    @Mock
    private AccountRepository repository;
    @InjectMocks
    private AccountServiceImpl sut;

    private ModelGenerator generator = new ModelGenerator();


    @BeforeEach
    void setUp() {
        when(mapper.toDto(any(AccountEntity.class))).thenReturn(generator.accountDtoGenerator());
    }

    @Test
    @DisplayName("Should create new account")
    void createNewAccount_should_return_a_valid_accountDto() {
        //given
        AccountEntity entity = generator.accountEntityGenerator();
        //when
        when(repository.create(any(AccountEntity.class))).thenReturn(entity);
        when(mapper.toEntity(any(AccountDto.class))).thenReturn(entity);
        AccountDto saved = sut.createNewAccount(generator.accountDtoGenerator());
        //then
        assertAll(
              () -> verify(repository).create(any(AccountEntity.class)),
              () -> assertNotNull(saved),
              () -> assertNotNull(saved.getId()));
    }

    @Test
    @DisplayName("Should find a valid account")
    void getAccountById_should_return_an_existing_account() {
        //given
        AccountEntity entity = generator.accountEntityGenerator();
        //when
        when(repository.find(anyLong())).thenReturn(Optional.of(entity));
        //then
        AccountDto foundAcount = sut.getAccountById(anyLong());
        assertAll(
              () -> verify(repository).find(anyLong()),
              () -> assertNotNull(foundAcount),
              () -> assertNotNull(foundAcount.getId()));
    }
}
