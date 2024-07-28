package com.thuong.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class AccountDto {
    private short id;
    private String email;
    private String username;
    private String fullname;
    private String password;
    private short courseId;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date createDate;

    public AccountDto(short id, String email, String username, String fullname, String password, short courseId, Date createDate) {
        super();
        this.id = id;
        this.email = email;
        this.username = username;
        this.fullname = fullname;
        this.password = password;
        this.courseId = courseId;
        this.createDate = createDate;
    }
}
