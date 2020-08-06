package com.scsa.VO;

import lombok.Data;

import java.io.Serializable;

/**
 * http请求返回的最外层对象,根据API文档
 * @Author: SCSA
 * @Date: 2020/7/28 22:08
 */
@Data
public class ResultVo<T> implements Serializable {

    private static final long serialVersionUID = 6399079180013333625L;
    
    /** 错误码 */
    private Integer code;

    /** 提示信息 */
    private String meg;

    /** 具体内容 */
    private T data;
}
