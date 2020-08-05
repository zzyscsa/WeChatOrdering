package com.scsa.exception;

import com.scsa.enums.ResultEnum;
import lombok.Getter;

/**
 * Sell异常处理
 * @Author: SCSA
 * @Date: 2020/7/29 20:55
 */
@Getter
public class SellException extends RuntimeException {

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }

    public SellException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
