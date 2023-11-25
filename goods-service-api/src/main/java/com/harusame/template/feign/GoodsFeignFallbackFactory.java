package com.harusame.template.feign;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GoodsFeignFallbackFactory implements FallbackFactory<GoodsFeignClient> {


    @Override
    public GoodsFeignClient create(Throwable throwable) {
        return new GoodsFeignClient() {

        };
    }
}
