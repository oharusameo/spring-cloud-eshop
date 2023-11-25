package com.harusame.template.api;

import com.harusame.template.domain.dto.AddGoodsDTO;
import com.harusame.template.domain.dto.GetGoodsDTO;
import com.harusame.template.domain.pojo.Goods;
import com.harusame.template.domain.pojo.Result;
import com.harusame.template.domain.vo.GoodsVo;
import com.harusame.template.service.GoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Api(tags = "商品接口")
@RestController
@RequestMapping("/api/v1/goods")
public class GoodsApi {
    @Resource
    private GoodsService goodsService;

    @PostMapping("/addGoods")
    @ApiOperation("添加商品接口")
    public Result addGoods(@ApiParam(name = "token", value = "身份认证令牌")
                           @RequestHeader String token, AddGoodsDTO addGoodsDTO) {
        goodsService.addGoods(addGoodsDTO);
        return Result.successMsg("添加商品成功");
    }

    @PostMapping("/getGoodsListByIds")
    @ApiOperation("根据商品id获取商品信息接口")
    public Result getGoodsListByIds(@ApiParam(name = "token", value = "身份认证令牌")
                                    @RequestHeader String token, @RequestBody @Valid GetGoodsDTO getGoodsDTO) {
        List<Goods> list = goodsService.getGoodsListByIds(getGoodsDTO.getGoodsIds());
        return Result.success(list);
    }


    @GetMapping("/getGoodsList")
    @ApiOperation("获取商品列表接口")
    public Result getGoodsList(@ApiParam(name = "token", value = "身份认证令牌")
                               @RequestHeader String token,
                               @RequestParam(defaultValue = "1") Integer pageNum,
                               @RequestParam(defaultValue = "5") Integer pageSize) {
        return Result.success(goodsService.getGoodsList(pageNum, pageSize));
    }

}
