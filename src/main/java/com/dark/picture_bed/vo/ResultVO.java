package com.dark.picture_bed.vo;

import lombok.Data;

@Data
public class ResultVO<T> {
    private Integer status;
    private String msg;
    private T data;

}
