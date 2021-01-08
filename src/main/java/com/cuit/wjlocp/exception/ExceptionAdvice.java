package com.cuit.wjlocp.exception;

import com.cuit.wjlocp.utils.Msg;
import com.mysql.cj.jdbc.exceptions.MysqlDataTruncation;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * @Auther: chocho
 * @Date: 2019/1/13 0013 1:18
 * @Description: 异常拦截
 */
@RestControllerAdvice
public class ExceptionAdvice {

    @ResponseBody
    @ExceptionHandler({Exception.class, NullPointerException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Msg ServerError(){
        return Msg.fail().add("msg", "系统出错，请联系管理员");
    }

}
