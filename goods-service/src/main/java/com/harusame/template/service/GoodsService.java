package com.harusame.template.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.harusame.template.domain.dto.AddGoodsDTO;
import com.harusame.template.domain.pojo.Goods;
import com.baomidou.mybatisplus.extension.service.IService;
import com.harusame.template.domain.vo.GoodsVo;

import java.math.BigDecimal;
import java.util.List;

/**
* @author ggzst
* @description 针对表【t_goods】的数据库操作Service
* @createDate 2023-11-24 19:27:02
*/
public interface GoodsService extends IService<Goods> {

    void addGoods(AddGoodsDTO addGoodsDTO);

    IPage<GoodsVo> getGoodsList(Integer pageNum, Integer pageSize);

    List<Goods> getGoodsListByIds(List<Integer> goodsIds);
}
