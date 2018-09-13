package com.myuserid.exception;

import com.myuserid.pojo.enums.StatusCode;
import com.myuserid.pojo.response.APIResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.MessageFormat;

/**
 * 统一异常类
 */
public class BusinessException extends RuntimeException {

    private static final Logger logger = LoggerFactory.getLogger(BusinessException.class);
    private Integer errorCode = 400;
    private String[] errorMessageArguments;
    private APIResponse apiResponse;

    private BusinessException() {
        this(StatusCode.InternalServerError);
    }

    public BusinessException(StatusCode statusCode) {
        this(statusCode.getCode(), statusCode.getMsg());
    }

    public BusinessException(Integer statusCode, String message) {
        super(message);
        this.errorCode = statusCode;
        this.errorMessageArguments = new String[0];
        StatusCode code = StatusCode.InternalServerError;
        code.setMsg(message);
        code.setCode(statusCode);
        apiResponse = new APIResponse().randerFail(code, message);
    }

    public BusinessException(StatusCode statusCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = statusCode.getCode();
        this.errorMessageArguments = new String[0];
        apiResponse = new APIResponse().randerFail(statusCode, message);
    }

    public Integer getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String[] getErrorMessageArguments() {
        return this.errorMessageArguments;
    }

    public void setErrorMessageArguments(String[] errorMessageArguments) {
        this.errorMessageArguments = errorMessageArguments;
    }

    public APIResponse response() {
        if (this.apiResponse != null) {
            return this.apiResponse;
        } else {
            this.apiResponse = new APIResponse().randerFail(StatusCode.ClientError);
            if (this.getErrorMessageArguments() != null && this.getErrorMessageArguments().length > 0) {
                try {
                    this.apiResponse.setMsg(MessageFormat.format(this.apiResponse.getMsg(), (Object) this.getErrorMessageArguments()));
                } catch (Exception var2) {
                    logger.error(var2.getMessage());
                }
            }

            return this.apiResponse;
        }
    }
}
