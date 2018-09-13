package com.myuserid.handler;

import com.myuserid.exception.BusinessException;
import com.myuserid.pojo.enums.StatusCode;
import com.myuserid.pojo.response.APIResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 统一异常处理
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(BusinessException.class);

    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public APIResponse businessException(Exception e) {

        AtomicReference<APIResponse> response = new AtomicReference<>(null);
        if (e instanceof BusinessException) {
            response.set(((BusinessException) e).response());
        } else {
            response.set(new APIResponse().randerFail(StatusCode.InternalServerError, e.getMessage()));
        }
        logger.error("find exception:e={}", e.getMessage());
        e.printStackTrace();
        return response.get();
    }
}
