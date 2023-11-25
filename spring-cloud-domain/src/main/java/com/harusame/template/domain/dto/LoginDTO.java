package com.harusame.template.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@ApiModel(value = "登录请求对象")
public class LoginDTO {
    @ApiModelProperty(value = "用户名", required = true)
    @NotBlank
    private String username;
    @ApiModelProperty(value = "密码", required = true)
    @NotBlank
    private String password;
}
