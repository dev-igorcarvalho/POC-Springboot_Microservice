package br.com.igorcarvalho.microservice.controller;

import br.com.igorcarvalho.microservice.model.dto.TransactionDto;
import br.com.igorcarvalho.microservice.model.request.TransactionPostRequest;
import br.com.igorcarvalho.microservice.util.ModelGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DisplayName("Transaction controller test")
@Sql(scripts = "/beforeTransactionTest.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
class TransactionControllerTest {

    private final String resourceUri = "/" + TransactionController.ROUTE;
    @Autowired
    private TransactionController controller;
    @Autowired
    private TestRestTemplate restTemplate;

    private ModelGenerator modelGenerator = new ModelGenerator();

    @Test
    @DisplayName("Should have a controller")
    void controller_should_exit_when_server_is_running() {
        Assertions.assertThat(controller).isNotNull();
    }

    @Test
    @DisplayName("Should return a new Transaction")
    void create_should_return_a_new_transaction() {
        TransactionPostRequest transactionPostRequest = modelGenerator.postRequestGenerator();
        ResponseEntity<TransactionDto> response =
              restTemplate.postForEntity(resourceUri, transactionPostRequest, TransactionDto.class);
        assertAll(
              () -> assertTrue(response.hasBody()),
              () -> assertNotNull(response.getBody().getId()),
              () -> assertNotNull(response.getBody().getEventDate()),
              () -> assertNotNull(response.getBody().getAmount()),
              () -> assertNotNull(response.getBody().getOperationTypeDto())
        );
    }

    @Test
    @DisplayName("Should return a 201 Created when a valid account is given")
    void create_should_return_Created_Status() {
        TransactionPostRequest transactionPostRequest = modelGenerator.postRequestGenerator();
        ResponseEntity<TransactionDto> response =
              restTemplate.postForEntity(resourceUri, transactionPostRequest, TransactionDto.class);
        assertAll(
              () -> assertNotNull(response),
              () -> assertEquals(HttpStatus.CREATED, response.getStatusCode()));
    }
}
