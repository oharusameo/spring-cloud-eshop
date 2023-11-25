package com.harusame.template.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@ApiModel("结算购物车请求对象")
public class SettleCartDTO {
    @ApiModelProperty(value = "商品id列表", example = "[1,2,3]")
    @NotNull
    private List<Integer> goodsIds;

}
