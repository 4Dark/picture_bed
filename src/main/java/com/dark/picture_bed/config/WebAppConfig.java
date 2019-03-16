package com.dark.picture_bed.config;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.servlet.MultipartConfigElement;

@Configuration
public class WebAppConfig extends WebMvcConfigurationSupport {

    /**
     * 文件上传配置
     * @return MultipartConfigElement
     * 或者在application文件里写
     * spring.servlet.multipart.maxFileSize=10Mb
     * spring.servlet.multipart.maxRequestSize=10Mb
     */
    @Bean
    public MultipartConfigElement multipartConfigElement(){
        MultipartConfigFactory multipartConfigFactory = new MultipartConfigFactory();
//     上传文件大小
        multipartConfigFactory.setMaxFileSize("1024KB");
//        设置上传数据总大小
        multipartConfigFactory.setMaxRequestSize("102400KB");
        return multipartConfigFactory.createMultipartConfig();
    }
}
