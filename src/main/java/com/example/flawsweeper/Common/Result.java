package com.example.flawsweeper.Common;

import lombok.Data;

/**
 * @description: 统一响应数据结果
 */
@Data
public class Result<T> {
    private String code;
    private String msg;
    private T data;


    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.code = "0";
        result.msg = "成功";
        result.setData(data);
        return result;
    }


    public static <T> Result<T> success() {
        Result<T> result = new Result<>();
        result.code = "0";
        result.msg = "成功";
        return result;
    }

    public static <T> Result<T> error(String code, String msg) {
        Result<T> result = new Result<>();
        result.code = "-1";
        result.msg = msg;
        return result;
    }

}
