package com.harusame.template.api;

import com.harusame.template.domain.dto.CreateOrderDTO;
import com.harusame.template.domain.pojo.Result;
import com.harusame.template.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@Api(tags = "订单接口")
@RestController
@RequestMapping("/api/v1/order")
public class OrderApi {

    @Resource
    private OrderService orderService;

    @ApiOperation("创建订单接口")
    @PostMapping("/createOrder")
    public Result createOrder(@ApiParam(name = "token", value = "身份认证令牌")
                              @RequestHeader String token, @RequestBody @Valid CreateOrderDTO createOrderDTO) {
        Integer orderId = orderService.createOrder(createOrderDTO);
        return Result.success(orderId);
    }

}
