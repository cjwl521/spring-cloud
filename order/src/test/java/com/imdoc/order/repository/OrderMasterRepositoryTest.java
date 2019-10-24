package com.imdoc.order.repository;

import com.imdoc.order.OrderApplicationTests;
import com.imdoc.order.dataobject.OrderMaster;
import com.imdoc.order.enums.OrderStatusEnum;
import com.imdoc.order.enums.PayStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author: Created by Jarries
 * @description:
 * @date: 2018/6/12
 */
public class OrderMasterRepositoryTest extends OrderApplicationTests{

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Test
    public void testSave(){
        OrderMaster orderMaster = new OrderMaster ();
        orderMaster.setOrderId("1234567");
        orderMaster.setBuyerName("师兄");
        orderMaster.setBuyerPhone("1886131241241");
        orderMaster.setBuyerAddress("慕课网总部");
        orderMaster.setBuyerOpenid("1101110");
        orderMaster.setOrderAmount(new BigDecimal (2.5));
        orderMaster.setOrderStatus ( OrderStatusEnum.NEW.getCode () );
        orderMaster.setPayStatus ( PayStatusEnum.WAIT.getCode () );
        OrderMaster result = orderMasterRepository.save (orderMaster);

        Assert.assertTrue ( result!=null );
    }
}