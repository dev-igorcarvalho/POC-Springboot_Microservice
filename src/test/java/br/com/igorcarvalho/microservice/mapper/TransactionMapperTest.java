package br.com.igorcarvalho.microservice.mapper;

import br.com.igorcarvalho.microservice.model.dto.OperationTypeDto;
import br.com.igorcarvalho.microservice.model.dto.TransactionDto;
import br.com.igorcarvalho.microservice.model.entity.AccountEntity;
import br.com.igorcarvalho.microservice.model.entity.OperationTypeEntity;
import br.com.igorcarvalho.microservice.model.entity.TransactionEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Transaction Mapper Tests")
class TransactionMapperTest {

    private TransactionEntity entity;
    private TransactionDto dto;

    private Mapper mapper;

    @BeforeEach
    void setUp() {
        OperationTypeDto operationTypeDto =
              OperationTypeDto.builder().id(1l).description("fake description").build();
        OperationTypeEntity operationTypeEntity =
              OperationTypeEntity.builder()
                    .id(1l).dscription("fake description").build();
        this.mapper = new TransactionMapper();
        this.entity = TransactionEntity.builder()
              .id(1L)
              .amount(new BigDecimal(123.44))
              .eventDate(LocalDateTime.now())
              .account(new AccountEntity())
              .operationType(operationTypeEntity)
              .build();
        this.dto = TransactionDto.builder()
              .amount(entity.getAmount())
              .eventDate(entity.getEventDate())
              .operationTypeDto(operationTypeDto)
              .id(entity.getId())
              .build();
    }

    @Test
    @DisplayName("Should map a given entity to dto")
    void toEntity_should_return_a_entity_from_given_dto() {
        //when
        TransactionEntity result = (TransactionEntity) this.mapper.toEntity(this.dto);
        //then
        assertAll(
              () -> assertNotNull(result),
              () -> assertNotNull(result.getId()),
              () -> assertEquals(result.getId(), dto.getId())
        );
    }

    @Test
    @DisplayName("Should map a given dto to entity")
    void toDto_should_return_a_dto_from_given_entity() {
        //when
        TransactionDto result = (TransactionDto) this.mapper.toDto(this.entity);
        //then
        assertAll(
              () -> assertNotNull(result),
              () -> assertNotNull(result.getId()),
              () -> assertEquals(result.getId(), dto.getId())
        );
    }

    @Test
    @DisplayName("Should map a given list of dtos to a list of entities")
    void toEntity_should_return_entities_from_given_dtos() {
        //when
        List<TransactionEntity> result = (List<TransactionEntity>) this.mapper.toEntity(List.of(this.dto));
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
        List<TransactionDto> result = (List<TransactionDto>) this.mapper.toDto(List.of(this.entity));
        //then
        assertAll(
              () -> assertNotNull(result),
              () -> assertFalse(result.isEmpty())
        );
    }
}
