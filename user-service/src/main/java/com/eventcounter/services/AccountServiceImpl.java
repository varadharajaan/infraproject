package com.eventcount.services;

import com.eventcount.entities.Account;
import com.eventcount.exceptions.DataNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.eventcount.repositories.AccountRepository;

/**
 * @see AccountService
 * @author eventcount
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Optional<Account> findById(long id) {
        return Optional.ofNullable(this.accountRepository.findOne(id));
    }

    @Override
    public List<Account> all() {
        return this.accountRepository.findAll();
    }

    @Override
    public Account save(Account user) {
        return this.accountRepository.save(user);
    }

    @Override
    public Account update(Long id, Account user) throws DataNotFoundException {
        return this.findById(id)
                .map(u -> {
                    u.setEmail(user.getEmail());
                    u.setName(user.getName());
                    u.setAuthId(user.getPassword());
                    return save(u);
                }).orElseThrow(() -> new DataNotFoundException("User not found"));
    }

    @Override
    public Optional<Account> findByEmail(String email) {
        return accountRepository.findByEmail(email);
    }

    @Override
    public void delete(Account a) {
        accountRepository.delete(a);
    }
}
