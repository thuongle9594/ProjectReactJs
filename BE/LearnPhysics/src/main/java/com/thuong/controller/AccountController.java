package com.thuong.controller;

import com.thuong.dto.AccountDto;
import com.thuong.entity.Account;
import com.thuong.form.account.AccountFilterForm;
import com.thuong.form.account.CreatingAccountForm;
import com.thuong.form.account.UpdateAccountForm;
import com.thuong.service.IAccountService;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping(value = "api/v1/accounts")
@CrossOrigin("*")

public class AccountController {
    @Autowired
    private IAccountService accountService;
    @Autowired
    private  ModelMapper modelMapper;

    public AccountController() {
    }

    @GetMapping()



//    public Page<AccountDto> getAllAccounts(Pageable pageable){
//        Page<Account> accountPage = accountService.getAllAccounts(pageable);
//        List<Account> accounts = accountPage.getContent();//lấy 1 list ở cái Content chạy ở postman ra để map, chỉ map cái list đó thôi, mọi thứ khác giữ nguyên
//        List<AccountDto> accountDtos = modelMapper.map(accounts, new TypeToken<List<AccountDto>>(){}.getType());
//        for(AccountDto accountDto : accountDtos){
//            accountDto.add(linkTo(methodOn(AccountController.class).getNhomhoctapById(accountDto.getId())).withSelfRel());
//        }
//        return new PageImpl<>(accountDtos, pageable, accountPage.getTotalElements());
//    }


//    public ResponseEntity<?> getAllAccounts(Pageable pageable) {
//        Page<Account> entities = accountService.getAllAccounts(pageable);
//
//        List<AccountDto> dtos = new ArrayList<>();
//
//        // convert entities --> dtos
//        for (Account account : entities) {
//            AccountDto dto = new AccountDto(account.getId(), account.getEmail(), account.getUsername(),
//                    account.getFullname(), account.getPassword() , account.getCourse().getId(),account.getCreateDate());
//            dtos.add(dto);
//        }
//
//        return new ResponseEntity<>(dtos, HttpStatus.OK);
//    }



    public Page<AccountDto> getAllAccounts(Pageable pageable, AccountFilterForm form) {

        Page<Account> entityPages = accountService.getAllAccounts(pageable, form);

        // convert entities --> dtos
        List<AccountDto> dtos = modelMapper.map(entityPages.getContent(), new TypeToken<List<AccountDto>>() {
        }.getType());

        Page<AccountDto> dtoPages = new PageImpl<>(dtos, pageable, entityPages.getTotalElements());

        return dtoPages;
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getAccountById(@PathVariable(name = "id") short id) {
        Account account = accountService.getAccountById(id);
        AccountDto dto = new AccountDto(account.getId(), account.getEmail(), account.getUsername(), account.getFullname(), account.getPassword() ,
                account.getCourse().getId(),account.getCreateDate());
        return new ResponseEntity<AccountDto>(dto, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> createAccount(@RequestBody CreatingAccountForm form) {
        accountService.createAccount(form);
        return new ResponseEntity<String>("Create successfully!", HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateAccount(@PathVariable(name = "id") short id,@RequestBody UpdateAccountForm form) {
        accountService.updateAccount(id, form);
        return new ResponseEntity<String>("Update successfully!", HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteAccount(@PathVariable(name = "id") short id) {
        accountService.deleteAccount(id);
        return new ResponseEntity<String>("Delete successfully!", HttpStatus.OK);
    }
}
