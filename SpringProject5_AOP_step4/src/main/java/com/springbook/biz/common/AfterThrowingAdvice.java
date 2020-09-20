package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterThrowingAdvice {
	
	@Pointcut("execution(* com.springbook.biz..*Impl.*(..))")
	public void allPointcut() {}
	
	@AfterThrowing(pointcut = "allPointcut()", throwing = "exObj")
	public void exceptionLog(JoinPoint jp, Exception exObj) {
		String method = jp.getSignature().getName();
		
		System.out.println("[사후 처리]" + method + "() 메소드 수행 중 발생된 예외 메세지 :" +
				exObj.getMessage());
		
		
		System.out.println(method + "() 부적합한 값이 입력되었습니다!");
		if(exObj instanceof IllegalArgumentException) {
			System.out.println("숫자 형식의 값이 아닙니다");
		}
		else if(exObj instanceof NumberFormatException) {
			System.out.println("문제가 발생했습니다.");
		}
	}
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
