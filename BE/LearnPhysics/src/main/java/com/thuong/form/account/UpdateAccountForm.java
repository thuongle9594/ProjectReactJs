package com.thuong.form.account;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UpdateAccountForm {
    //private String email;
    private String username;
    private String fullname;
    private String password;
    private short courseId;
}
