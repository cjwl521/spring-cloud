package com.imdoc.order.service;

import com.imdoc.order.dto.OrderDTO;

/**
 * @author: Created by Jarries
 * @description:
 * @date: 2018/6/12
 */
public interface OrderService {

    /**
     * 创建订单
     * @param orderDTO
     * @return
     */
    OrderDTO create(OrderDTO orderDTO);
}
