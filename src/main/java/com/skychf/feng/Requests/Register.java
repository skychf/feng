package com.skychf.feng.Requests;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;
import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.core.annotation.AliasFor;
import org.springframework.data.annotation.TypeAlias;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class Register {

    @NotEmpty(message = "用户名不能为空")
    private String username;

    @NotEmpty(message = "密码不能为空")
    @Size(min = 3, max = 5, message = "密码长度为3〜5位")
    private String password;
}
