package com.bnuz.handler;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Chanchitin
 * @date 2021/5/8
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BusinessException extends RuntimeException{
    @ApiModelProperty(value = "错误码")
    private  Integer code;
    @ApiModelProperty(value = "错误信息")
    private  String errMsg;

    public BusinessException(String errMsg){
        this.errMsg=errMsg;
    }
}
