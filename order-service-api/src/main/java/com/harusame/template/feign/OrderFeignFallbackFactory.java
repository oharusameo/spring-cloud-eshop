package com.harusame.template.feign;

import com.harusame.template.domain.dto.CreateOrderDTO;
import com.harusame.template.domain.pojo.Order;
import com.harusame.template.domain.pojo.Result;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrderFeignFallbackFactory implements FallbackFactory<OrderFeignClient> {


    @Override
    public OrderFeignClient create(Throwable throwable) {
        return new OrderFeignClient() {

            @Override
            public Result createOrder(String token, CreateOrderDTO createOrderDTO) {
                return Result.success(new Order());
            }
        };
    }
}
