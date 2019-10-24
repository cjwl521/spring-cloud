package com.imdoc.product.VO;

import lombok.Data;

/**
 * @author: Created by Jarries
 * @description:
 * @date: 2018/6/8
 */
@Data
public class ResultVO<T> {

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 具体内容
     */
    private T data;
}
