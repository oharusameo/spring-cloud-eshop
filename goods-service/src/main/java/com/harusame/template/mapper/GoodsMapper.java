package com.harusame.template.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.harusame.template.domain.pojo.Goods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.harusame.template.domain.vo.GoodsVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author ggzst
 * @description 针对表【t_goods】的数据库操作Mapper
 * @createDate 2023-11-24 19:27:02
 * @Entity com.harusame.template.domain.pojo.Goods
 */
public interface GoodsMapper extends BaseMapper<Goods> {

    @Select("select * from t_goods ${ew.customSqlSegment}")
    IPage<GoodsVo> selectPage(Page<Goods> page, @Param(Constants.WRAPPER) Wrapper<Goods> wrapper);
}




