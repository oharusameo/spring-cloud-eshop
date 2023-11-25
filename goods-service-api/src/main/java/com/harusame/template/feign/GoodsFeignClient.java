package com.harusame.template.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "goods-service", fallbackFactory = GoodsFeignFallbackFactory.class)
@RequestMapping("/api/v1/goods")
public interface GoodsFeignClient {
    

}
