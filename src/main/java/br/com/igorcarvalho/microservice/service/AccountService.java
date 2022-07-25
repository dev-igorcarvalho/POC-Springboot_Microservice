package br.com.igorcarvalho.microservice.service;

import br.com.igorcarvalho.microservice.model.dto.AccountDto;

public interface AccountService {
    AccountDto createNewAccount(AccountDto dto);

    AccountDto getAccountById(Long accountId);
//    Page<AccountDto> findPaginated(int pageNo, int pageSize );
}
