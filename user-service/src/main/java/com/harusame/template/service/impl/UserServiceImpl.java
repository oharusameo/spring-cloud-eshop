package com.harusame.template.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.harusame.template.domain.dto.LoginDTO;
import com.harusame.template.domain.pojo.User;
import com.harusame.template.domain.vo.UserVo;
import com.harusame.template.exception.BusinessException;
import com.harusame.template.service.UserService;
import com.harusame.template.mapper.UserMapper;
import com.harusame.template.utils.TokenUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ggzst
 * @description 针对表【t_user】的数据库操作Service实现
 * @createDate 2023-11-24 19:50:41
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private TokenUtils tokenUtils;

    @Override
    public String login(LoginDTO loginDTO) {
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("username", loginDTO.getUsername())
                .eq("password", loginDTO.getPassword()).select("id"));
        if (user == null) {
            throw new BusinessException("用户名或密码错误");
        }
        return tokenUtils.loginAndGetToken(user.getId());
    }

    @Override
    public UserVo getUserInfo() {
        String userId = tokenUtils.getUserIdFromHeader();
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("id", userId).select("id", "username", "telephone"));
        if (user == null) {
            throw new BusinessException("用户不存在");
        }
        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(user, userVo);
        return userVo;
    }


}




