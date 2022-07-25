package br.com.igorcarvalho.microservice.model.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "Accounts")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@SuppressWarnings("JpaDataSourceORMInspection")
public class AccountEntity {
    @Id
    @GeneratedValue
    @Column(name = "Account_ID")
    private Long id;

    @NotNull
    @NotBlank
    @Size(min = 11, max = 11)
    @Column(name = "Document_Number", nullable = false, length = 11, unique = true)
    private String documentNumber;

    @OneToMany(mappedBy = "account", orphanRemoval = true)
    private List<TransactionEntity> transactions;

}
