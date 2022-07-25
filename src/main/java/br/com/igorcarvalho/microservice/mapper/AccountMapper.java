package br.com.igorcarvalho.microservice.mapper;

import br.com.igorcarvalho.microservice.model.dto.AccountDto;
import br.com.igorcarvalho.microservice.model.entity.AccountEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Qualifier("accountMapper")
@RequiredArgsConstructor
public class AccountMapper implements Mapper<AccountEntity, AccountDto> {
    private final TransactionMapper transactionMapper;

    @Override
    public AccountEntity toEntity(AccountDto dto) {
        return AccountEntity.builder().id(dto.getId()).documentNumber(dto.getDocumentNumber()).transactions(transactionMapper.toEntity(dto.getTransactions())).build();
    }

    @Override
    public AccountDto toDto(AccountEntity entity) {
        return AccountDto.builder().id(entity.getId()).documentNumber(entity.getDocumentNumber()).transactions(transactionMapper.toDto(entity.getTransactions())).build();
    }

    @Override
    public List<AccountEntity> toEntity(List<AccountDto> dtos) {
        List<AccountEntity> result = dtos.stream().map(e -> this.toEntity(e)).collect(Collectors.toList());
        return result;
    }

    @Override
    public List<AccountDto> toDto(List<AccountEntity> entities) {
        List<AccountDto> result = entities.stream().map(e -> this.toDto(e)).collect(Collectors.toList());
        return result;
    }
}
