package com.dark.picture_bed.controller;


import com.dark.picture_bed.constant.Constants;
import com.dark.picture_bed.enums.ResultEnum;
import com.dark.picture_bed.exception.PictureBedException;
import com.dark.picture_bed.utils.ImageUtil;
import com.dark.picture_bed.utils.ResultVOUtil;
import com.dark.picture_bed.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/index")
@Slf4j
public class indexController {

    @GetMapping("")
    public ResultVO index() {
        log.info("index");
        return ResultVOUtil.success();
    }

    @GetMapping("/picture")
    public ResultVO getPicture(HttpRequest request) {
        log.info("【START】method getPicture");
        return null;
    }

    @PostMapping("/picture")
    public ResultVO postPicture(@RequestParam("imageFile")MultipartFile multipartFile) {
        log.info("【START】method postPicture");
        //        判断用户是否有权限
//        List<String> token = request.getHeaders().get("token");
//        if(StringUtils.equals(token,Constants.TOKEN)){
//            return ResultVOUtil.error(400,"token 不正确")；
//        }
        if (multipartFile.isEmpty() || StringUtils.isBlank(multipartFile.getOriginalFilename())) {
            throw new PictureBedException(ResultEnum.IMG_EMPTY);
        }
// TODO 此处应根据 linux 和windows 设置不同的路径根据不同的用户，设定不同的存储文件夹，暂时写死
        String path = "/Users/pei/program/java/IdeaProjects/demo/picture_bed/upload";
        try {
            ImageUtil.saveImg(multipartFile, path);
            log.info("【END】postPicture: 上传成功");
            return ResultVOUtil.success();
        } catch (IOException e) {
            e.printStackTrace();
            log.info("【END】postPicture: 上传失败");
            throw new PictureBedException(ResultEnum.IMG_SAVE_ERROE);
        }

    }

}
