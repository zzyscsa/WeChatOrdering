package com.scsa.utils;

import com.scsa.VO.ResultVo;

/**
 * @Author: SCSA
 * @Date: 2020/7/28 22:53
 */
public class ResultVOUtil {

    public static ResultVo success(Object object) {
        ResultVo resultVo = new ResultVo();
        resultVo.setData(object);
        resultVo.setMeg("成功");
        resultVo.setCode(0);
        return resultVo;
    }

    public static ResultVo success() {
        return null;
    }

    public static ResultVo error(Integer code, String msg) {
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(code);
        resultVo.setMeg(msg);
        return resultVo;
    }

}
