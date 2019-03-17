package com.dark.picture_bed.utils;

import org.springframework.web.multipart.MultipartFile;
import sun.tools.java.Constants;


import java.io.*;

public class ImageUtil {
    public static String saveImg(MultipartFile multipartFile,String path) throws IOException {
        File file = new File(path);
        if(!file.exists()) file.mkdirs();
        FileInputStream fileInputStream = (FileInputStream) multipartFile.getInputStream();
//        String filename = Constants.getUUID()
//        通过hash 进行命名
        String filename = MD5Util.md5HashCode32(fileInputStream)+".png";
// 关注I/O 输入输出流 的  适配器模式和装饰器模式
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(path + File.separator + filename));
        byte[] bs = new byte[1024];
        int len;
        while((len = fileInputStream.read(bs))!=-1){
            bufferedOutputStream.write(bs,0,len);
        }
        bufferedOutputStream.flush();
        bufferedOutputStream.close();
        fileInputStream.close();
        return filename;
    }
}
