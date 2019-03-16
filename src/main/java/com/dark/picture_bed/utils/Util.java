package com.dark.picture_bed.utils;

import com.dark.picture_bed.constant.Constants;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Collections;

public class Util {
    private final static String[] fileType = {"jpg", "jpeg", "gif", "png"};

    public static Boolean checkHost(String host) {
        for (String temp : Constants.allowHost) {
            if (StringUtils.equals(temp, host)) {
                return true;
            }
        }
        return false;

    }

    public String getSuffix(String filename) {
        String[] split = filename.split(".");
        String type = split[split.length - 1];
        for (String temp : fileType) {
            if (StringUtils.equals(type, temp)) {
                return type;
            }
        }
        return "illegal";
    }
}
