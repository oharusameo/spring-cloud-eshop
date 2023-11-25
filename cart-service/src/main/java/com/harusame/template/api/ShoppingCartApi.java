package com.harusame.template.api;

import cn.dev33.satoken.annotation.SaCheckLogin;
import com.harusame.template.domain.dto.AddCartDTO;
import com.harusame.template.domain.dto.SettleCartDTO;
import com.harusame.template.domain.pojo.Result;
import com.harusame.template.domain.vo.CartVo;
import com.harusame.template.service.CartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
@Api(tags = "购物车接口", value = "CartAPI")
@RequestMapping("/api/v1/cart")
public class ShoppingCartApi {
    @Resource
    private CartService cartService;

    @PostMapping("/addGoodsToCart")
    @ApiOperation("添加商品到购物车")
    public Result addGoodsToCart(@ApiParam(name = "token", value = "身份认证令牌")
                                 @RequestHeader String token, @RequestBody @Valid AddCartDTO addCartDTO) {
        cartService.addGoodsToCart(addCartDTO);
        return Result.success();
    }

    @PostMapping("showShoppingCart")
    @ApiOperation("展示购物车")
    public Result showShoppingCart(@ApiParam(name = "token", value = "身份认证令牌")
                                   @RequestHeader String token) {
        List<CartVo> cartList = cartService.showCart();
        return Result.success(cartList);

    }

    @PostMapping("settleShoppingCart")
    @ApiOperation("结算购物车")
    public Result settleShoppingCart(@ApiParam(name = "token", value = "身份认证令牌")
                                     @RequestHeader String token, @RequestBody @Valid SettleCartDTO settleCartDTO) {
        cartService.settleCart(settleCartDTO);
        return Result.success();
    }

}
