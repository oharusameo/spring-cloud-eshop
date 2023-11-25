package com.harusame.template.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.harusame.template.domain.pojo.Goods;
import com.harusame.template.mapper.GoodsMapper;
import com.harusame.template.service.GoodsService;
import org.springframework.stereotype.Service;

/**
* @author ggzst
* @description 针对表【t_goods】的数据库操作Service实现
* @createDate 2023-11-24 19:27:02
*/
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods>
    implements GoodsService{

}




