package com.harusame.template.feign;

import com.harusame.template.domain.dto.GetGoodsDTO;
import com.harusame.template.domain.pojo.Result;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class GoodsFeignFallbackFactory implements FallbackFactory<GoodsFeignClient> {


    @Override
    public GoodsFeignClient create(Throwable throwable) {
        return new GoodsFeignClient() {

            @Override
            public Result getGoodsListByIds(String token, GetGoodsDTO getGoodsDTO) {
                return Result.success(new ArrayList<>());
            }
        };
    }
}
