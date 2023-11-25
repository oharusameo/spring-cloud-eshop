package com.harusame.template.feign;

import com.harusame.template.domain.dto.GetGoodsDTO;
import com.harusame.template.domain.pojo.Result;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@FeignClient(value = "goods-service", fallbackFactory = GoodsFeignFallbackFactory.class)
@RequestMapping("/api/v1/goods")
public interface GoodsFeignClient {
    @PostMapping("/getGoodsListByIds")
    Result getGoodsListByIds(@ApiParam(name = "token", value = "身份认证令牌")
                             @RequestHeader String token, @RequestBody @Valid GetGoodsDTO getGoodsDTO);

}
