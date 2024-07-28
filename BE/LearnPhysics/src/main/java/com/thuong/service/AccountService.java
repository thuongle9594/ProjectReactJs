package com.thuong.service;

import com.thuong.entity.Account;
import com.thuong.entity.Course;
import com.thuong.form.account.AccountFilterForm;
import com.thuong.form.account.CreatingAccountForm;
import com.thuong.form.account.UpdateAccountForm;
import com.thuong.repository.IAccountRepository;
import com.thuong.repository.ICourseRepository;

import com.thuong.specification.AccountSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
@Service
public class AccountService implements IAccountService{
    @Autowired
    private IAccountRepository accountRepository;
    @Autowired
    private ICourseRepository courseRepository;

    @Override
    public Page<Account> getAllAccounts(Pageable pageable, AccountFilterForm form) {
        Specification<Account> where = AccountSpecification.buildWhere(form);
        // TODO Auto-generated method stub
        return accountRepository.findAll(where,pageable);
    }

    @Override
    public Account getAccountById(short id) {
        // TODO Auto-generated method stub
        return accountRepository.getById(id);
    }

    @Override
    public Account getAccountByUsername(String username) {
        return null;
    }

    @Override
    public void deleteAccount(short id) {
        accountRepository.deleteById(id);

    }

    @Override
    public boolean isAccountExistsById(short id) {
        return false;
    }

    @Override
    public boolean isAccountExistsByUsername(String username) {
        return false;
    }

    @Override
    public void createAccount(CreatingAccountForm form) {
        Account account = new Account();
        Course course =  courseRepository.getById(form.getCourseId());
        account.setEmail(form.getEmail());
        account.setUsername(form.getUsername());
        account.setFullname(form.getFullname());
        account.setPassword(form.getPassword());
        account.setCourse(course);
        accountRepository.save(account);
    }

    @Override
    public void updateAccount(short id, UpdateAccountForm form) {
        Account account = accountRepository.getById(id);
        Course course =  courseRepository.getById(form.getCourseId());
        //account.setEmail(form.getEmail());
        account.setUsername(form.getUsername());
        account.setFullname(form.getFullname());
        account.setPassword(form.getPassword());
        account.setCourse(course);
        accountRepository.save(account);
    }
}
