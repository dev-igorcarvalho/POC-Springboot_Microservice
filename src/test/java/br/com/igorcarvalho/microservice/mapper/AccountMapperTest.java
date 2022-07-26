package br.com.igorcarvalho.microservice.mapper;

import br.com.igorcarvalho.microservice.model.dto.AccountDto;
import br.com.igorcarvalho.microservice.model.entity.AccountEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Account Mapper Tests")
class AccountMapperTest {

    private AccountEntity entity;
    private AccountDto dto;
    private AccountMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new AccountMapper(new TransactionMapper());
        this.entity = AccountEntity.builder()
              .id(1L)
              .documentNumber("12345678900")
              .transactions(new ArrayList<>())
              .build();
        this.dto = AccountDto.builder()
              .documentNumber(entity.getDocumentNumber())
              .id(entity.getId())
              .transactions(new ArrayList<>())
              .build();
    }

    @Test
    @DisplayName("Should map a given entity to dto")
    void toEntity_should_return_a_entity_from_given_dto() {
        //when
        AccountEntity result = (AccountEntity) this.mapper.toEntity(this.dto);
        //then
        assertAll(
              () -> assertNotNull(result),
              () -> assertNotNull(result.getId()),
              () -> assertNotNull(result.getDocumentNumber()),
              () -> assertEquals(result.getDocumentNumber(), dto.getDocumentNumber()),
              () -> assertEquals(result.getTransactions().size(), dto.getTransactions().size()),
              () -> assertEquals(result.getId(), dto.getId())
        );
    }

    @Test
    @DisplayName("Should map a given dto to entity")
    void toDto_should_return_a_dto_from_given_entity() {
        //when
        AccountDto result = (AccountDto) this.mapper.toDto(this.entity);
        //then
        assertAll(
              () -> assertNotNull(result),
              () -> assertNotNull(result.getId()),
              () -> assertNotNull(result.getDocumentNumber()),
              () -> assertEquals(result.getDocumentNumber(), entity.getDocumentNumber()),
              () -> assertEquals(result.getTransactions().size(), entity.getTransactions().size()),
              () -> assertEquals(result.getId(), dto.getId())
        );
    }

    @Test
    @DisplayName("Should map a given list of dtos to a list of entities")
    void toEntity_should_return_entities_from_given_dtos() {
        //when
        List<AccountEntity> result = (List<AccountEntity>) this.mapper.toEntity(List.of(this.dto));
        //then
        assertAll(
              () -> assertNotNull(result),
              () -> assertFalse(result.isEmpty())
        );
    }

    @Test
    @DisplayName("Should map a given list of entities to a list of dtos")
    void toDto_should_return_dtos_from_given_entites() {
        //when
        List<AccountDto> result = (List<AccountDto>) this.mapper.toDto(List.of(this.entity));
        //then
        assertAll(
              () -> assertNotNull(result),
              () -> assertFalse(result.isEmpty())
        );
    }
}
