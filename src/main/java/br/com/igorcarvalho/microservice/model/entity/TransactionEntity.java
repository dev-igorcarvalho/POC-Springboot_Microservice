package br.com.igorcarvalho.microservice.model.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "Transactions")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@SuppressWarnings("JpaDataSourceORMInspection")
public class TransactionEntity {
    @Id
    @GeneratedValue
    @Column(name = "Transaction_ID")
    private Long id;

    @NotNull
    @Column(name = "Amount", nullable = false)
    private BigDecimal amount;

    @NotNull
    @Column(name = "EventDate", nullable = false)
    private LocalDateTime eventDate;

    @ManyToOne(optional = false)
    @JoinColumn(name = "OperationType_ID", nullable = false)
    private OperationTypeEntity operationType;

    @ManyToOne
    @JoinColumn(name = "Account_ID")
    private AccountEntity account;

}
