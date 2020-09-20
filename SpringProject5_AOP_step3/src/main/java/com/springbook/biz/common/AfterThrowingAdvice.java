package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;

public class AfterThrowingAdvice {
	
	public void exceptionLog(JoinPoint jp, Exception exObj) {
		String method = jp.getSignature().getName();
		
		System.out.println("[예외처리]" + method + "() 메소드 수행 중 발생도니 예외 메세지 :" +
				exObj.getMessage());
		
		
		System.out.println(method + "() 메소드 수행 중 예외 발생!");
		if(exObj instanceof IllegalArgumentException) {
			System.out.println("부적합한 값이 입력되었습니다.");
		}
		else if(exObj instanceof NumberFormatException) {
			System.out.println("숫자 형식의 값이 아닙니다.");
		}
	}
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
