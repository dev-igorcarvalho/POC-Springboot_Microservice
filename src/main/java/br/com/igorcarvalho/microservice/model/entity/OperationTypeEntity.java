package br.com.igorcarvalho.microservice.model.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "OperationsTypes")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@SuppressWarnings("JpaDataSourceORMInspection")
public class OperationTypeEntity {
    @Id
    @GeneratedValue
    @Column(name = "OperationType_ID")
    private Long id;

    @NotNull
    @NotBlank
    @Column(name = "Description", nullable = false)
    private String dscription;

}
