package com.example.flawsweeper.Common;

import cn.hutool.core.date.DateUtil;

import java.util.UUID;

/**
 * @program: codeduck
 * @description:
 * @author: CodeDuck
 * @create: 2020-07-30 09:39
 **/
public class StringUtil {

    /**
     * @Description: 生成唯一图片名称
     * @Param: fileName
     * @return: 云服务器fileName
     */
    public static String getRandomImgName(String fileName) {

        int index = fileName.lastIndexOf(".");

        if ((fileName == null || fileName.isEmpty()) || index == -1){
            throw new IllegalArgumentException();
        }
        // 获取文件后缀
        String suffix = fileName.substring(index);
        // 生成UUID
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        // 生成上传至云服务器的路径
        String path = "code/duck/" + DateUtil.today() + "-" + uuid + suffix;
        return path;
    }
}
