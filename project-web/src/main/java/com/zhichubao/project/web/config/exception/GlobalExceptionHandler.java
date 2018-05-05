package com.zhichubao.project.web.config.exception;


import com.zhichubao.project.core.exception.BusinessException;
import com.zhichubao.project.core.result.ErrorCodeEnum;
import com.zhichubao.project.core.result.ResultBean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.nio.file.AccessDeniedException;

/**
 * 全局的的异常拦截器
 *
 * @author wzw
 */
//组合注解
@ControllerAdvice
public class GlobalExceptionHandler {

	/**
	 * 参数非法异常.
	 *
	 * @param e the e
	 *
	 * @return the wrapper
	 */
	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public ResultBean illegalArgumentException(IllegalArgumentException e) {
//		log.error("参数非法异常={}", e.getMessage(), e);
		return ResultBean.createdResultBean(ErrorCodeEnum.GL99990100.code(),null,e.getMessage());
	}

	/**
	 * 业务异常.
	 *
	 * @param e the e
	 *
	 * @return the wrapper
	 */
	@ExceptionHandler(BusinessException.class)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public ResultBean businessException(BusinessException e) {
//		log.error("业务异常={}", e.getMessage(), e);
		return ResultBean.createdResultBean(ErrorCodeEnum.GL99990500.code(),null,e.getMessage());
	}

	/**
	 * 无权限访问.
	 *
	 * @param e the e
	 *
	 * @return the wrapper
	 */
	@ExceptionHandler(AccessDeniedException.class)
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	@ResponseBody
	public ResultBean unAuthorizedException(AccessDeniedException e) {
//		log.error("无权访问={}", e.getMessage(), e);
		return ResultBean.createdResultBean(ErrorCodeEnum.GL99990401.code(),null,e.getMessage());
	}


	/**
	 * 全局异常.
	 *
	 * @param e the e
	 *
	 * @return the wrapper
	 */
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public ResultBean exception(Exception e) {
//		log.info("保存全局异常信息 ex={}", e.getMessage(), e);
		return ResultBean.createdResultBean(ErrorCodeEnum.GL99990500.code(),null,ErrorCodeEnum.GL99990500.msg());
	}

	@ExceptionHandler(Exception.class)
	public String viewException(Exception e){
		return "error";
	}

}
