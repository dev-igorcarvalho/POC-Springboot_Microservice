package br.com.igorcarvalho.microservice.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AccountDto {
    private Long id;

    @NotNull
    @NotBlank
    @Size(min = 11, max = 11)
    private String documentNumber;

    private Set<TransactionDto> transactions;
}
