package com.bizideal.mn.aspect;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author 作者 liulq:
 * @data 创建时间：2017年7月3日 上午10:03:17
 * @version 1.0
 * @description 描述
 */
@Aspect
@Component
public class AopHandler {

	// aop demo，配置拦截的是类AopController1和类AopController2中的get方法
	@Pointcut("execution(* com.bizideal.mn.controller.AopController1.get(java.lang.String)) "
			+ "|| execution(* com.bizideal.mn.controller.AopController2.get(java.lang.String)) "
			+ "|| execution(* com.bizideal.mn.controller.AopController2.post(java.lang.String))")
	public void pointCut() {

	}

	// 配置环绕通知,配置环绕通知后前置通知不会失效,环绕通知必须有返回值，返回值即目标方法的返回值
	// 几种通知执行顺序
	// 1.环绕通知
	// 2.环绕通知调用proceed方法后，前置通知开始执行
	// 3.方法主体执行
	// 4.环绕通知
	// 5.后置通知
	// 6.返回通知
	@Around(value = "pointCut()")
	public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println("around...");
		System.out.println("参数检查开始...");
		Map<String, String> map = new HashMap<String, String>();
		Object[] args = proceedingJoinPoint.getArgs();
		if (args == null || args[0] == null) {
			map.put("status", "1");
			map.put("msg", "缺少参数");
			return map;
		}
		if (args[0].toString().length() != 11) {
			map.put("status", "1");
			map.put("msg", "非法手机号");
			return map;
		}
		Object proceed = proceedingJoinPoint.proceed();
		System.out.println("around...");
		return proceed;
	}

	// 配置前置通知,使用在方法pointCut()上注册的切入点
	@Before(value = "pointCut()", argNames = "joinPoint")
	public void before(JoinPoint joinPoint) {
		System.out.println("before...");
	}

	// 配置后置返回通知,使用在方法pointCut()上注册的切入点
	@After(value = "pointCut()")
	public void after() {
		System.out.println("after...");
	}

	// 配置后置返回通知,使用在方法pointCut()上注册的切入点,可以获取返回值
	@AfterReturning(value = "pointCut()", returning = "result")
	public void AfterReturning(JoinPoint joinPoint, Object result) {
		System.out.println("AfterReturning...,result = " + result);
	}

	// 配置抛出异常后通知,使用在方法pointCut()上注册的切入点
	@AfterThrowing(pointcut = "pointCut()", throwing = "ex")
	public void afterThrow(JoinPoint joinPoint, Exception ex) {
		System.out.println("afterThrow...");
	}

}
