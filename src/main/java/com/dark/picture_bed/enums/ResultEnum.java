package com.dark.picture_bed.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {
    PARAM_ERROR(1, "参数不正确"),
    IMG_SAVE_ERROE(100,"图像保存失败"),
    IMG_EMPTY(2,"图像为空");
    private Integer code;
    private String message;
    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
