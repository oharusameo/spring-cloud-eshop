package com.harusame.template.feign;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrderFeignFallbackFactory implements FallbackFactory<OrderFeignClient> {


    @Override
    public OrderFeignClient create(Throwable throwable) {
        return new OrderFeignClient() {

        };
    }
}
