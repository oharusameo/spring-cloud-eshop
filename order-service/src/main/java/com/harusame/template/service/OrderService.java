package com.harusame.template.service;

import com.harusame.template.domain.dto.CreateOrderDTO;
import com.harusame.template.domain.pojo.Order;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author ggzst
* @description 针对表【t_order】的数据库操作Service
* @createDate 2023-11-24 19:27:55
*/
public interface OrderService extends IService<Order> {

    Integer createOrder(CreateOrderDTO createOrderDTO);
}
