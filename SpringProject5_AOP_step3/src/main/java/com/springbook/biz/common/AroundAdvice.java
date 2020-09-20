package com.springbook.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class AroundAdvice {

	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		String method = pjp.getSignature().getName();
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		Object Obj = pjp.proceed();
		stopWatch.stop();
		System.out.println(method + "() 메소드 시행에 걸린 시간"
					+ stopWatch.getTotalTimeMillis() + "(ms)초");
		
		
		
		return Obj; 
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
