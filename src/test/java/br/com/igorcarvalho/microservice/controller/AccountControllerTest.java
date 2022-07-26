package br.com.igorcarvalho.microservice.controller;

import br.com.igorcarvalho.microservice.model.dto.AccountDto;
import br.com.igorcarvalho.microservice.util.ModelGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AccountControllerTest {

    private final String resourceUri = "/" + AccountController.ROUTE;
    @Autowired
    private AccountController controller;
    @Autowired
    private TestRestTemplate restTemplate;
    private ModelGenerator modelGenerator = new ModelGenerator();

    @BeforeEach
    void setUp() {
    }

    @Test
    @DisplayName("Should has a controller")
    void controller_should_exit_when_server_is_running() {
        Assertions.assertThat(controller).isNotNull();
    }

    @Test
    @DisplayName("Should return a new Account")
    void create_should_return_a_new_account() {
        final String docNumber = "12312312301";
        AccountDto dto = AccountDto.builder()
              .documentNumber(docNumber)
              .transactions(new ArrayList<>())
              .build();
        ResponseEntity<AccountDto> response =
              restTemplate.postForEntity(resourceUri, dto, AccountDto.class);
        assertAll(
              () -> assertTrue(response.hasBody()),
              () -> assertNotNull(response.getBody().getId()),
              () -> assertNotNull(response.getBody().getTransactions()),
              () -> assertNotNull(response.getBody().getDocumentNumber()),
              () -> assertEquals(1L, response.getBody().getId()),
              () -> assertEquals(docNumber, response.getBody().getDocumentNumber())
        );
    }

    @Test
    @DisplayName("Should return a 201 Created when a valid account is given")
    void create_should_return_Created_Status() {
        AccountDto dto = AccountDto.builder()
              .documentNumber("12312312300")
              .transactions(new ArrayList<>())
              .build();
        ResponseEntity<AccountDto> response =
              restTemplate.postForEntity(resourceUri, dto, AccountDto.class);
        assertAll(
              () -> assertNotNull(response),
              () -> assertEquals(HttpStatus.CREATED, response.getStatusCode()));
    }

    @Test
    @DisplayName("Should return a 200 ok when a valid id is given")
    void get_should_return_Ok_status() {
        ResponseEntity<AccountDto> response =
              restTemplate.getForEntity(resourceUri + "/1", AccountDto.class);
        assertAll(
              () -> assertNotNull(response),
              () -> assertEquals(HttpStatus.OK, response.getStatusCode()));
    }

    @Test
    @DisplayName("Should return an existing account when a valid id is given")
    void get_should_return_and_existing_account() {
        ResponseEntity<AccountDto> response =
              restTemplate.getForEntity(resourceUri + "/1", AccountDto.class);
        assertAll(
              () -> assertTrue(response.hasBody()),
              () -> assertNotNull(response.getBody().getId()),
              () -> assertNotNull(response.getBody().getTransactions()),
              () -> assertNotNull(response.getBody().getDocumentNumber()),
              () -> assertEquals(1L, response.getBody().getId())
        );
    }
}
