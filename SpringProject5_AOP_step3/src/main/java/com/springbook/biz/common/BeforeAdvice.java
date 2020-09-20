package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;

public class BeforeAdvice {

	
	public void beforeLog(JoinPoint jp) {
		
		String method = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		System.out.println("[사전처리]" + method +
						"() 메소드ARGS 정보 : " + args[0].toString()); 
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
