package com.harusame.template.api;

import cn.dev33.satoken.annotation.SaCheckLogin;
import com.harusame.template.domain.dto.LoginDTO;
import com.harusame.template.domain.pojo.Result;
import com.harusame.template.domain.pojo.User;
import com.harusame.template.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@Api(tags = "用户接口")
@RestController
@RequestMapping("/api/v1/user")
public class UserApi {
    @Resource
    private UserService userService;


    @PostMapping("/login")
    @ApiOperation("用户登录接口")
    public Result login(@Valid @RequestBody LoginDTO loginDTO) {
        String token = userService.login(loginDTO);
        return Result.success(token);
    }

    @GetMapping("/getUserInfo")
    @ApiOperation("获取用户信息接口")
    @SaCheckLogin
    public Result getUserInfo(@ApiParam(name = "token", value = "身份认证令牌")
                              @RequestHeader String token) {
        User user = userService.getUserInfo();
        return Result.success(user);
    }

}
