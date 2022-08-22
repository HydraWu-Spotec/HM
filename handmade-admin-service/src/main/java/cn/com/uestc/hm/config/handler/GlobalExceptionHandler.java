package cn.com.uestc.hm.config.handler;

import cn.com.uestc.base.ApiResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ApiResult<Void> exceptionHandler(Exception e) {
        if (log.isErrorEnabled()) log.error("全局异常捕获", e);
        return ApiResult.fail();
    }
}
