package com.harusame.template.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "order-service", fallbackFactory = OrderFeignFallbackFactory.class)
@RequestMapping("/api/v1/order")
public interface OrderFeignClient {
    

}
