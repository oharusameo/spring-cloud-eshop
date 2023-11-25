package com.harusame.template.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.harusame.template.domain.dto.AddGoodsDTO;
import com.harusame.template.domain.pojo.Goods;
import com.harusame.template.domain.vo.GoodsVo;
import com.harusame.template.exception.BusinessException;
import com.harusame.template.mapper.GoodsMapper;
import com.harusame.template.service.GoodsService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author ggzst
 * @description 针对表【t_goods】的数据库操作Service实现
 * @createDate 2023-11-24 19:27:02
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods>
        implements GoodsService {
    @Resource
    private GoodsMapper goodsMapper;

    @Override
    public void addGoods(AddGoodsDTO addGoodsDTO) {
        Goods goods = new Goods();
        BeanUtils.copyProperties(addGoodsDTO, goods);
        goodsMapper.insert(goods);
    }

    @Override
    public IPage<GoodsVo> getGoodsList(Integer pageNum, Integer pageSize) {
        Page<Goods> goodsPage = new Page<>(pageNum, pageSize);
        IPage<GoodsVo> page = goodsMapper.selectPage(goodsPage, new QueryWrapper<>());
        if (page.getRecords() == null || page.getRecords().size() == 0) {
            throw new BusinessException("没有商品");
        }
        return page;
    }

    @Override
    public List<Goods> getGoodsListByIds(List<Integer> goodsIds) {
        List<Goods> goods = goodsMapper.selectBatchIds(goodsIds);
        if (goods == null) {
            throw new BusinessException("商品不存在");
        }
        return goods;
    }
}




