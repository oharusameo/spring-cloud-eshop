package com.harusame.template.domain.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartVo {
    private Integer userId;
    private String goodsName;
    private Integer goodsNum;
    private BigDecimal totalPrice;
}
