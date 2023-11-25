package com.harusame.template.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@ApiModel("添加商品请求对象")
public class AddGoodsDTO {
    @NotBlank
    @ApiModelProperty(value = "商品名称", required = true)
    private String goodsName;
    @NotNull
    @ApiModelProperty(value = "商品价格", required = true)
    private BigDecimal goodsPrice;
}
