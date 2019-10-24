package com.imdoc.order.repository;

import com.imdoc.order.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: Created by Jarries
 * @description:
 * @date: 2018/6/12
 */
public interface OrderDetailRepository extends JpaRepository <OrderDetail, String> {
}
