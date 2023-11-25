package com.harusame.template.mapper;

import com.harusame.template.domain.pojo.Cart;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.harusame.template.domain.vo.CartVo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
* @author ggzst
* @description 针对表【t_cart】的数据库操作Mapper
* @createDate 2023-11-24 19:24:46
* @Entity com.harusame.template.domain.pojo.Cart
*/
public interface CartMapper extends BaseMapper<Cart> {

}




