package com.harusame.template.service;

import com.harusame.template.domain.dto.LoginDTO;
import com.harusame.template.domain.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.harusame.template.domain.vo.UserVo;

/**
* @author ggzst
* @description 针对表【t_user】的数据库操作Service
* @createDate 2023-11-24 19:50:41
*/
public interface UserService extends IService<User> {

    String login(LoginDTO loginDTO);

    UserVo getUserInfo();

}
