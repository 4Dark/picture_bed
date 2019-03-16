package com.dark.picture_bed.controller;


import com.dark.picture_bed.constant.Constants;
import com.dark.picture_bed.enums.ResultEnum;
import com.dark.picture_bed.exception.PictureBedException;
import com.dark.picture_bed.utils.ResultVOUtil;
import com.dark.picture_bed.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/index")
@Slf4j
public class indexController {

    @GetMapping("")
    public ResultVO index(){
        log.info("index");
        log.info("index");
        return ResultVOUtil.success();
    }
    @GetMapping("/picture")
    public ResultVO getPicture(HttpRequest request){
        log.info("【START】method getPicture");

    }
    @PostMapping("/picture")
    public ResultVO postPicture(HttpRequest request, MultipartFile multipartFile){
        log.info("【START】method postPicture");
        //        判断用户是否有权限
//        List<String> token = request.getHeaders().get("token");
//        if(StringUtils.equals(token,Constants.TOKEN)){
//            return ResultVOUtil.error(400,"token 不正确")；
//        }
        if (multipartFile.isEmpty() || StringUtils.isBlank(multipartFile.getOriginalFilename())) {
            throw new PictureBedException(ResultEnum.IMG_EMPTY);
        }
        return ResultVOUtil.success();
        //todo
    }

}
