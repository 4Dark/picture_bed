package com.dark.picture_bed.utils;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {

    public static String md5HashCode(InputStream inputStream) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
//            分批读入
            byte[] buffer = new byte[1024];
            int length = -1;
            while ((length = inputStream.read(buffer, 0, 1024)) != -1) {
                md5.update(buffer, 0, length);
            }
            inputStream.close();
//          转换并返回包含16个元素字节数组，-128~127
            byte[] md5Bytes = md5.digest();
            BigInteger bigInteger = new BigInteger(1, md5Bytes);
            return bigInteger.toString();  // 转换位16进制
        } catch (NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String md5HashCode32(InputStream inputStream) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] buffer = new byte[1024];
            int length = -1;
            while ((length = inputStream.read(buffer, 0, 1024)) != -1) {
                md5.update(buffer, 0, length);
            }
//            inputStream.close();
            byte[] digest = md5.digest();

            //  转换并返回包含16个元素字节数组，返回数值范围  -128～127
            StringBuffer hexValue = new StringBuffer();
            for (int i = 0; i < digest.length; i++) {
                int val = ((int) digest[i] & 0xff);
                if (val < 16) {
                    hexValue.append("0");
                }
//                注意下toHexString的参数 格式
                hexValue.append(Integer.toHexString(val));
            }
            return hexValue.toString();
        } catch (NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
            return "";
        }
    }
    /*
     * 方法md5HashCode32 中     ((int) md5Bytes[i]) & 0xff   操作的解释：
     * 在Java语言中涉及到字节byte数组数据的一些操作时，经常看到 byte[i] & 0xff这样的操作，这里就记录总结一下这里包含的意义：
     * 1、0xff是16进制（十进制是255），它默认为整形，二进制位为32位，最低八位是“1111 1111”，其余24位都是0。
     * 2、&运算: 如果2个bit都是1，则得1，否则得0；
     * 3、byte[i] & 0xff：首先，这个操作一般都是在将byte数据转成int或者其他整形数据的过程中；使用了这个操作，最终的整形数据只有低8位有数据，其他位数都为0。
     * 4、这个操作得出的整形数据都是大于等于0并且小于等于255的
     */
}
