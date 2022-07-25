package br.com.igorcarvalho.microservice.repository;

import br.com.igorcarvalho.microservice.model.entity.AccountEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@DisplayName("Account Repository tests")
class AccountRepositoryImplTest {

    @Autowired
    private AccountRepository repository;

    @Test
    @DisplayName("Should persist a new account")
    void save_should_persist_a_valid_new_account() {
        //given
        AccountEntity toBeSaved = AccountEntity.builder().documentNumber("12345678900").build();
        //when
        AccountEntity saved = repository.create(toBeSaved);
        //then
        assertAll(
              () -> assertNotNull(saved),
              () -> assertNotNull(saved.getId()),
              () -> assertNotNull(saved.getDocumentNumber()),
              () -> assertEquals(toBeSaved.getDocumentNumber(), saved.getDocumentNumber())
        );
    }

    @Test
    @DisplayName("Should retrieve an existing account by its id")
    void find_should_retrieve_a_account() {
        //given
        AccountEntity toBeSaved = AccountEntity.builder().documentNumber("12345678900").build();
        repository.create(toBeSaved);
        //when
        Optional<AccountEntity> optional = repository.find(toBeSaved.getId());

        //then
        assertAll(
              () -> assertTrue(optional.isPresent()),
              () -> assertNotNull(optional.get()),
              () -> assertNotNull(optional.get().getId()),
              () -> assertNotNull(optional.get().getDocumentNumber()),
              () -> assertEquals(toBeSaved.getDocumentNumber(), optional.get().getDocumentNumber())
        );
    }

    @Test
    @DisplayName("Should not find any account when the passed id is not valid")
    void find_should_not_retrieve_an_account() {
        //given
        final long invalidId = 7L;
        //when
        Optional<AccountEntity> optional = repository.find(invalidId);
        //then
        assertTrue(optional.isEmpty());
    }
}
