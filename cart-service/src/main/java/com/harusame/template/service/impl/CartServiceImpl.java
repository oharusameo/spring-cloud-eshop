package com.harusame.template.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.harusame.template.domain.dto.AddCartDTO;
import com.harusame.template.domain.dto.CreateOrderDTO;
import com.harusame.template.domain.dto.GetGoodsDTO;
import com.harusame.template.domain.dto.SettleCartDTO;
import com.harusame.template.domain.pojo.Cart;
import com.harusame.template.domain.pojo.Goods;
import com.harusame.template.domain.pojo.Result;
import com.harusame.template.domain.vo.CartVo;
import com.harusame.template.exception.BusinessException;
import com.harusame.template.feign.GoodsFeignClient;
import com.harusame.template.feign.OrderFeignClient;
import com.harusame.template.mapper.CartMapper;
import com.harusame.template.service.CartService;
import com.harusame.template.utils.ResultUtils;
import com.harusame.template.utils.TokenUtils;
import com.mysql.cj.xdevapi.JsonArray;
import io.swagger.util.Json;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author ggzst
 * @description 针对表【t_cart】的数据库操作Service实现
 * @createDate 2023-11-24 19:24:46
 */
@Service
@Slf4j
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart>
        implements CartService {
    @Resource
    private TokenUtils tokenUtils;
    @Resource
    private CartMapper cartMapper;

    @Resource
    private GoodsFeignClient goodsFeignClient;

    @Resource
    private OrderFeignClient orderFeignClient;

    @Override
    public void addGoodsToCart(AddCartDTO addCartDTO) {
        String userId = tokenUtils.getUserIdFromHeader();
        Cart c = cartMapper.selectOne(new QueryWrapper<Cart>().eq("user_id", userId).eq("goods_id", addCartDTO.getGoodsId()));
        if (c != null) {
            c.setGoodsNum(c.getGoodsNum() + addCartDTO.getGoodsNum());
            cartMapper.update(c, new QueryWrapper<Cart>().eq("user_id", userId).eq("goods_id", c.getGoodsId()));
            return;
        }
        Cart cart = new Cart();
        BeanUtils.copyProperties(addCartDTO, cart);
        cart.setUserId(Integer.valueOf(userId));
        cartMapper.insert(cart);
    }

    @Override
    public List<CartVo> showCart() {
        String userId = tokenUtils.getUserIdFromHeader();
        List<Cart> cartList = cartMapper.selectList(new QueryWrapper<Cart>().eq("user_id", userId));
        List<Integer> goodsIds = cartList.stream().map(Cart::getGoodsId).collect(Collectors.toList());
        return showCart(cartList, goodsIds);
    }

    @Override
    public void settleCart(SettleCartDTO settleCartDTO) {
        List<Integer> goodsIds = settleCartDTO.getGoodsIds();
        List<CartVo> cartVoList = showCartByGoodsIds(goodsIds);
        BigDecimal totalPrice = new BigDecimal(0);
        for (CartVo cartVo : cartVoList) {
            totalPrice = totalPrice.add(cartVo.getTotalPrice());
        }
        log.info("totalPrice: {}", totalPrice);

        String token = tokenUtils.getTokenFromHeader();
        CreateOrderDTO createOrderDTO = new CreateOrderDTO();
        createOrderDTO.setTotalPrice(totalPrice);
        Result result = orderFeignClient.createOrder(token, createOrderDTO);
        log.info("result={}",result.getData());
//        Integer orderId = JSONUtil.toBean((String) result.getData(), Integer.class);
//        log.info("orderId: {}", orderId);
    }

    public List<CartVo> showCartByGoodsIds(List<Integer> goodsIds) {
        String userId = tokenUtils.getUserIdFromHeader();
        List<Cart> cartList = cartMapper.selectList(new QueryWrapper<Cart>().eq("user_id", userId).in("goods_id", goodsIds));
        return showCart(cartList, goodsIds);
    }

    private List<CartVo> showCart(List<Cart> cartList, List<Integer> goodsIds) {
        String token = tokenUtils.getTokenFromHeader();
        String userId = StpUtil.getLoginIdAsString();
        Result result = goodsFeignClient.getGoodsListByIds(token, new GetGoodsDTO(goodsIds));
        if (result.getStatusCode() != 200) {
            throw new BusinessException(result.getMessage());
        }

        JSONArray jsonArray = JSONUtil.parseArray(result.getData());
        List<Goods> goodsList = jsonArray.toList(Goods.class);
        List<CartVo> cartVos = new ArrayList<>();
        for (Cart cart : cartList) {
            Integer goodsId = cart.getGoodsId();
            for (Goods goods : goodsList) {
                if (!Objects.equals(goods.getId(), goodsId)) {
                    continue;
                }
                CartVo cartVo = new CartVo();
                cartVo.setGoodsName(goods.getGoodsName());
                cartVo.setUserId(Integer.valueOf(userId));
                cartVo.setGoodsNum(cart.getGoodsNum());
                Integer goodsNum = cart.getGoodsNum();
                BigDecimal goodsPrice = goods.getGoodsPrice();
                BigDecimal totalPrice = (goodsPrice.multiply(new BigDecimal(goodsNum)));
                cartVo.setTotalPrice(totalPrice);
                cartVos.add(cartVo);
            }
        }
        return cartVos;
    }


}




