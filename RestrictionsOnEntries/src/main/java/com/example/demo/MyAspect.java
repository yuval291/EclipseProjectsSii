package com.example.demo;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {
	
	private Map<String, Boolean> entrances = new HashMap<String, Boolean>();

	@Around("@annotation(MyAnnotation))")
	public Object func(ProceedingJoinPoint jp) throws Throwable{
		
		MethodSignature signature = (MethodSignature) jp.getSignature();
		Method method = signature.getMethod();
		
		if (method != null) {
			if (!entrances.containsKey(method.getName())) {
				entrances.put(method.getName(), true);
			}
			MyAnnotation entriesAnnotation = method.getAnnotation(MyAnnotation.class);

			if (entrances.get(method.getName())) {
				
				entrances.put(method.getName(), false);
				return jp.proceed();
			}
		}
		throw new Exception("Error entering");
	}
}
