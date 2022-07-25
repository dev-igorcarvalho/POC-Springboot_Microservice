package br.com.igorcarvalho.microservice.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@JsonIgnoreProperties(ignoreUnknown = true)
@RequiredArgsConstructor
@Value
public class TransactionPostRequest {
    @NotNull
    private long accountId;

    @NotNull
    private long operationTypeId;

    @NotNull
    private Double amount;
}
