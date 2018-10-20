package com.ljb.exception;

import com.alibaba.fastjson.JSON;
import com.ljb.dao.SysLogDao;
import com.ljb.entity.Identity;
import com.ljb.entity.SysLog;
import com.ljb.security.IdentityUtils;
import com.ljb.utils.DateUtils;
import com.ljb.utils.ExceptionUtils;
import com.ljb.utils.R;
import com.ljb.utils.RequestUtils;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.UnexpectedTypeException;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @Autowired
    private SysLogDao sysLogDao;
    @Autowired
    private HttpServletRequest httpServletRequest;


    /**
     * 统一处理参数绑定错误
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public R handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        Map<String, Object> attrMap = new HashMap<String, Object>();
        for (FieldError error : fieldErrors) {
            attrMap.put(error.getField(), error.getDefaultMessage());
        }
        recodError( e.getStackTrace(),"数据绑定失败",e.getParameter().toString(),1);
        return R.error(403, "数据校验失败").put("data", attrMap);
    }



    //参数类型不匹配
//getPropertyName()获取数据类型不匹配参数名称
//getRequiredType()实际要求客户端传递的数据类型
    @ExceptionHandler({TypeMismatchException.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public R requestTypeMismatch(TypeMismatchException e){
        recodError( e.getStackTrace(),"数据类型错误",e.getPropertyName(),1);
        return R.error(402, "参数类型不匹配,参数" + e.getPropertyName() + "类型应该为" + e.getRequiredType());
    }
    //缺少参数异常
//getParameterName() 缺少的参数名称
    @ExceptionHandler({MissingServletRequestParameterException.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public R requestMissingServletRequest(MissingServletRequestParameterException e){
        recodError( e.getStackTrace(),"缺少参数:",e.getParameterName().toString(),1);
        return R.error(402, "缺少必要参数,参数名称为" + e.getParameterName());
    }

    @ExceptionHandler({NoHandlerFoundException.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public R noHandlerFound(HttpMessageNotReadableException e){
        recodError( e.getStackTrace(),"访问路径不存在",null,2);
        return R.error(404, "访问失败，页面找不到");
    }

    @ExceptionHandler({HttpMessageNotReadableException.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public R httpMessageNotReadable(HttpMessageNotReadableException e){
        recodError( e.getStackTrace(),"访问路径不存在",null,2);
        return R.error(404, "访问失败，页面找不到");
    }

    @ExceptionHandler({UnexpectedTypeException.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public R paramsError(UnexpectedTypeException e){
       recodError( e.getStackTrace(),"参数类型错误",null,1);
        return R.error(402, "参数类型错误："+e.getMessage());
    }

    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public R exception(Exception e){
        recodError( e.getStackTrace(),"未知错误",null,3);
        return R.error(401, "未知错误："+e.getMessage());
    }

    public void recodError(StackTraceElement[] stackTraceElements, String message, String methodParameter,Integer level){
        SysLog sysLog=new SysLog();
        try {
            if (SecurityUtils.getSubject().isAuthenticated()) {
                sysLog.setCreateId(IdentityUtils.getUserId());
                sysLog.setRemark("系统用户");
            } else {
                sysLog.setRemark("未知用户");
            }
            sysLog.setUrl(httpServletRequest.getRequestURI());
            sysLog.setOperation(httpServletRequest.getMethod());
            sysLog.setRemark(message);
            sysLog.setIp(RequestUtils.getIp(httpServletRequest));
            sysLog.setErrorStack(ExceptionUtils.getStackMsg(stackTraceElements));
            sysLog.setCreateTime(DateUtils.currentTime());
            sysLog.setLevel(level);
            sysLog.setUpdateTime(DateUtils.currentTime());
            sysLog.setMethod(httpServletRequest.getMethod());
            sysLog.setParams(JSON.toJSONString(httpServletRequest.getParameterMap()) + httpServletRequest.getQueryString());
            sysLogDao.insert(sysLog);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
