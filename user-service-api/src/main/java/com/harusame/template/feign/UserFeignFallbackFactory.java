package com.harusame.template.feign;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserFeignFallbackFactory implements FallbackFactory<UserFeignClient> {


    @Override
    public UserFeignClient create(Throwable throwable) {
        return new UserFeignClient() {

        };
    }
}
