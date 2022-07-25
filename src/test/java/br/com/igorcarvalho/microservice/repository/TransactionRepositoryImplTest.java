package br.com.igorcarvalho.microservice.repository;

import br.com.igorcarvalho.microservice.model.entity.TransactionEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@DisplayName("Transaction Repository tests")
class TransactionRepositoryImplTest {

    @Autowired
    private TransactionRepository repository;

    @Test
    @DisplayName("Should persist a new transaction")
    void save_should_persist_a_valid_new_transaction() {
        //given
        TransactionEntity toBeSaved = TransactionEntity.builder()
              .eventDate(LocalDateTime.now())
              .amount(new BigDecimal(123.33))
              .build();
        //when
        TransactionEntity saved = repository.create(toBeSaved);
        //then
        assertAll(
              () -> assertNotNull(saved),
              () -> assertNotNull(saved.getId()),
              () -> assertEquals(toBeSaved.getAmount(), saved.getAmount()),
              () -> assertEquals(toBeSaved.getEventDate(), saved.getEventDate())
        );
    }


}
