package com.dark.picture_bed.utils;

import com.dark.picture_bed.vo.ResultVO;

public class ResultVOUtil {
    public static ResultVO success(Object data){
        ResultVO resultVO = new ResultVO();
        resultVO.setData(data);
        resultVO.setMsg("success");
        resultVO.setStatus(0);
        return resultVO;
    }
    public static ResultVO success(){
        return success(null);
    }
    public static ResultVO error(Integer status,String msg){
        ResultVO resultVO = new ResultVO();
        resultVO.setMsg("fail");
        resultVO.setStatus(status);
        return resultVO;
    }
}
