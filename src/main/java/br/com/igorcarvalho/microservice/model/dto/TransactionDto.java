package br.com.igorcarvalho.microservice.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TransactionDto {
    private Long id;

    @NotNull
    private BigDecimal amount;

    @NotNull
    private LocalDateTime eventDate;

    @NotNull
    private OperationTypeDto operationTypeDto;
}
