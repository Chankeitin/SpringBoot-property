package com.bnuz.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Result {
    @ApiModelProperty(value = "是否操作成功")
    private  boolean success;
    @ApiModelProperty(value = "操作码")
    private  Integer code;
    @ApiModelProperty(value = "操作信息")
    private  String message;
    @ApiModelProperty(value = "操作数据")
    private Map<String,Object> data=new HashMap<>();

    private  Result(){}

    public  static Result ok(){
        Result result=new Result();
        result.setSuccess(true);
        result.setCode(ResultCode.SUCCESS.getCode());
        result.setMessage(ResultCode.SUCCESS.getMessage());
        return  result;
    }
    public  static Result error(){
        Result result=new Result();
        result.setSuccess(false);
        result.setCode(ResultCode.ERROR.getCode());
        result.setMessage(ResultCode.ERROR.getMessage());
        return  result;
    }
    public Result success(Boolean success){
        this.setSuccess(success);
        return  this;

    }

    public Result code(Integer code){
        this.setCode(code);
        return  this;
    }

    public Result message(String message){
        this.setMessage(message);
        return  this;
    }

    public Result data(String key,Object data){
        this.data.put(key, data);
        return  this;
    }

    public Result data(Map<String, Object> map){
        this.setData(map);
        return this;
    }
}
