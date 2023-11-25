package com.harusame.template.domain.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import static cn.hutool.http.HttpStatus.HTTP_INTERNAL_ERROR;
import static cn.hutool.http.HttpStatus.HTTP_OK;

/**
 * 返回给前端的通用对象
 */
@ApiModel
@Data
public class Result {
    @ApiModelProperty(value = "业务处理响应码")
    private Integer statusCode;
    //逻辑状态码（开发者自定义）不是http响应状态码，
    // 一般200认为成功，500任务逻辑有问题
    @ApiModelProperty("业务处理返回信息")
    private String message;

    @ApiModelProperty("业务处理成功后返回的数据")
    private Object data;

    /**
     * 下面是常用快捷方法
     */

    public static Result success() {

        Result result = new Result();
        result.statusCode = HTTP_OK;
        result.message = "success";
        return result;
    }

    public static Result success(String msg, Object data) {
        Result result = new Result();
        result.statusCode = HTTP_OK;
        result.data = data;
        result.message = msg;
        return result;
    }

    public static Result successMsg(String msg) {
        Result result = new Result();
        result.statusCode = HTTP_OK;
        result.message = msg;
        return result;
    }

    public static Result success(Object data) {
        Result result = new Result();
        result.statusCode = HTTP_OK;
        result.data = data;
        return result;
    }

    public static Result error() {
        Result result = new Result();
        result.statusCode = HTTP_INTERNAL_ERROR;
        result.message = "error";
        return result;
    }

    public static Result error(String msg) {
        Result result = new Result();
        result.statusCode = HTTP_INTERNAL_ERROR;
        result.message = msg;
        return result;
    }

    public static Result error(Integer customCode, String msg) {
        Result result = new Result();
        result.statusCode = customCode;
        result.message = msg;
        return result;
    }

    private Result() {
    }


}
