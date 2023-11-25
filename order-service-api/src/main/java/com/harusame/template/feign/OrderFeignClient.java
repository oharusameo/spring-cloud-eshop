package com.harusame.template.feign;

import com.harusame.template.domain.dto.CreateOrderDTO;
import com.harusame.template.domain.pojo.Result;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@FeignClient(value = "order-service", fallbackFactory = OrderFeignFallbackFactory.class)
@RequestMapping("/api/v1/order")
public interface OrderFeignClient {
    @PostMapping("createOrder")
    Result createOrder(@ApiParam(name = "token", value = "身份认证令牌")
                       @RequestHeader String token, @RequestBody @Valid CreateOrderDTO createOrderDTO);

}
