package com.thuong.repository;

import com.thuong.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IAccountRepository extends JpaRepository<Account,Short>, JpaSpecificationExecutor<Account> {
    boolean existsByUsername (String username);
    Account
    findByUsername (String username);
}
