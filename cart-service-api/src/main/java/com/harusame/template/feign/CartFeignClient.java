package com.harusame.template.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "cart-service", fallbackFactory = CartFeignFallbackFactory.class)
@RequestMapping("/api/v1/cart")
public interface CartFeignClient {


}
