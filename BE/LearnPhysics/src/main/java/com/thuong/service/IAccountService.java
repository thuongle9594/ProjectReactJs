package com.thuong.service;

import com.thuong.entity.Account;
import com.thuong.form.account.AccountFilterForm;
import com.thuong.form.account.CreatingAccountForm;
import com.thuong.form.account.UpdateAccountForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IAccountService {

    public Page<Account> getAllAccounts(Pageable pageable, AccountFilterForm form);
    public Account getAccountById(short id);
    public Account getAccountByUsername(String username);
    public  void createAccount(CreatingAccountForm form);
    public void updateAccount(short id,UpdateAccountForm form);
    public void deleteAccount(short id);
    public boolean isAccountExistsById(short id);

	public boolean isAccountExistsByUsername(String username);

}
