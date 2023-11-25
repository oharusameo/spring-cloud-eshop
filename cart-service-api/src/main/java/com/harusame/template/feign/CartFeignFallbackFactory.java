package com.harusame.template.feign;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CartFeignFallbackFactory implements FallbackFactory<CartFeignClient> {


    @Override
    public CartFeignClient create(Throwable throwable) {
        return new CartFeignClient() {

        };
    }
}
