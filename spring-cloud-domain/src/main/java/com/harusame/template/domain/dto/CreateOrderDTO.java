package com.harusame.template.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Data
@ApiModel("创建订单请求对象")
public class CreateOrderDTO {
//    @NotNull
    @ApiModelProperty(value = "下单的商品id", example = "[1,2,3]")
    private List<Integer> goodsIds;
    @NotNull
    @ApiModelProperty(value = "下单的商品总价", example = "100.00")
    private BigDecimal totalPrice;
}
