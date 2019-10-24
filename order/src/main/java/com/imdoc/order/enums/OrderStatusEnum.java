package com.imdoc.order.enums;

import lombok.Getter;

/**
 * @author: Created by Jarries
 * @description:
 * @date: 2018/6/12
 */
@Getter
public enum OrderStatusEnum {
    NEW ( 0, "新订单" ),
    FINISHED ( 1, "完结" ),
    CANCEL ( 2, "取消" ),;
    private Integer code;

    private String message;

    OrderStatusEnum (Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
