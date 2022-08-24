package com.example.demo;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class EntriesAspect {

	private Map<String, Integer> counters = new HashMap<String, Integer>();

	@Around("@annotation(Entries))")
	public Object handleLimition(ProceedingJoinPoint jp) throws Throwable {
		MethodSignature signature = (MethodSignature) jp.getSignature();
		Method method = signature.getMethod();
		
		if (method != null) {
			if (!counters.containsKey(method.getName())) {
				counters.put(method.getName(), 0);
			}
			Entries entriesAnnotation = method.getAnnotation(Entries.class);
			Integer counter = counters.get(method.getName());

			if (entriesAnnotation.entries() > counter) {
				counter++;
				counters.put(method.getName(), counter);
				return jp.proceed();
			}
		}
		throw new Exception("Max executions limit exceeded");
	}

}
