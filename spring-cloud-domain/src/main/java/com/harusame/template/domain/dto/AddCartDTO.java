package com.harusame.template.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@ApiModel("添加购物车请求对象")
public class AddCartDTO {
    @NotNull
    @ApiModelProperty(value = "商品id", example = "1")
    private Integer goodsId;
    @NotNull
    @ApiModelProperty(value = "商品数量", example = "1")
    private Integer goodsNum;
}
