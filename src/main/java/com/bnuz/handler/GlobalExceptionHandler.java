package com.bnuz.handler;


import com.bnuz.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Chanchitin
 * @date 2021/5/8
 * 全局异常处理
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e){
        //e.printStackTrace();
        log.error(e.toString());
        return Result.error();
    }

    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public Result err1(BusinessException e){
        log.error(e.toString());
        return  Result.error().code(e.getCode()).message(e.getErrMsg());
    }
}
