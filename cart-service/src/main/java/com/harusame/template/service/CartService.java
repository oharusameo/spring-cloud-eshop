package com.harusame.template.service;

import com.harusame.template.domain.dto.AddCartDTO;
import com.harusame.template.domain.dto.SettleCartDTO;
import com.harusame.template.domain.pojo.Cart;
import com.baomidou.mybatisplus.extension.service.IService;
import com.harusame.template.domain.vo.CartVo;

import java.util.List;

/**
 * @author ggzst
 * @description 针对表【t_cart】的数据库操作Service
 * @createDate 2023-11-24 19:24:46
 */
public interface CartService extends IService<Cart> {

    void addGoodsToCart(AddCartDTO addCartDTO);

    List<CartVo> showCart();

    void settleCart(SettleCartDTO settleCartDTO);

}
