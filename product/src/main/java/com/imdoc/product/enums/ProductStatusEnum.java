package com.imdoc.product.enums;

import lombok.Getter;

/**
 * @author: Created by Jarries
 * @description:
 * @date: 2018/6/8
 */
@Getter
public enum ProductStatusEnum {
    UP(0, "在架"),
    DOWN(1, "下架"),
    ;

    private Integer code;

    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
