package com.harusame.template.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "user-service", fallbackFactory = UserFeignFallbackFactory.class)
@RequestMapping("/api/v1/user")
public interface UserFeignClient {
    

}
