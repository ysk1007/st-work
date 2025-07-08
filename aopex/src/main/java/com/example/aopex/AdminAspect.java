package com.example.aopex;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AdminAspect {

	// 전
	@Before("execution(* com.example.aopex.HelloController.adminLogin(..))")
	public void before() {
		System.out.println("~~~~~~~~~Before AOP~~~~~~~~~");
	}
	
	// 후
	@After("execution(* com.example.aopex.HelloController.adminLogin(..))")
	public void after() {
		System.out.println("~~~~~~~~~After AOP~~~~~~~~~");
	}
}
