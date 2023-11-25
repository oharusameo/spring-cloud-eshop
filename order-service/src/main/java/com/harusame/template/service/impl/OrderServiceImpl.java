package com.harusame.template.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.harusame.template.domain.dto.CreateOrderDTO;
import com.harusame.template.domain.pojo.Order;
import com.harusame.template.mapper.OrderMapper;
import com.harusame.template.service.OrderService;
import com.harusame.template.utils.TokenUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ggzst
 * @description 针对表【t_order】的数据库操作Service实现
 * @createDate 2023-11-24 19:27:55
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order>
        implements OrderService {

    @Resource
    private OrderMapper orderMapper;
    @Resource
    private TokenUtils tokenUtils;

    @Override
    public Integer createOrder(CreateOrderDTO createOrderDTO) {
        Order order = new Order();
        order.setTotalPrice(createOrderDTO.getTotalPrice());
        order.setUserId(Integer.valueOf(tokenUtils.getUserIdFromHeader()));
        order.setTitle("订单订单订单");
        orderMapper.insert(order);
        return order.getId();
    }
}




