package com.harusame.template.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@ApiModel("获取商品列表请求对象")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetGoodsDTO {
    @NotNull
    @ApiModelProperty(value = "商品id列表", example = "[1,2,3]")
    private List<Integer> goodsIds;
}
