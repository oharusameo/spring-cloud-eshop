package com.harusame.template.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.harusame.template.domain.pojo.Order;
import com.harusame.template.mapper.OrderMapper;
import com.harusame.template.service.OrderService;
import org.springframework.stereotype.Service;

/**
* @author ggzst
* @description 针对表【t_order】的数据库操作Service实现
* @createDate 2023-11-24 19:27:55
*/
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order>
    implements OrderService{

}




