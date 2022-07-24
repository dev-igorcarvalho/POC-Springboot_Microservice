package br.com.igorcarvalho.microservice.mapper;

import br.com.igorcarvalho.microservice.model.dto.AccountDto;
import br.com.igorcarvalho.microservice.model.entity.AccountEntity;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Qualifier("accountMapper")
public class AccountMapper implements Mapper<AccountEntity, AccountDto> {
    @Override
    public AccountEntity toEntity(AccountDto accountDto) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public AccountDto toDto(AccountEntity accountEntity) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public List<AccountEntity> toEntity(List<AccountDto> accountDtos) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public List<AccountDto> toDto(List<AccountEntity> accountEntities) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }
}
