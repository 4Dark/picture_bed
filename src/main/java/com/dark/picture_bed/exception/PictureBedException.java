package com.dark.picture_bed.exception;

import com.dark.picture_bed.enums.ResultEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

//https://blog.csdn.net/zhanlanmg/article/details/50392266
@Data
@EqualsAndHashCode(callSuper=true)
public class PictureBedException extends RuntimeException{
    private Integer code;
    public PictureBedException(ResultEnum resultEnum){
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
