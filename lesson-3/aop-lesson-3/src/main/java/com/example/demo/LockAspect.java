package com.example.demo;

import java.lang.reflect.Method;
import java.util.concurrent.locks.ReentrantLock;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LockAspect {
	
	 ReentrantLock lock = new ReentrantLock();

		@Around("@annotation(Lock)")
		public void handleLock(ProceedingJoinPoint jp) throws Throwable
		{
			MethodSignature signature = (MethodSignature) jp.getSignature();
			Method method = signature.getMethod();
			if(method != null)
			{
				String tName = Thread.currentThread().getName();
		        System.out.println(tName + " before locking");
		        boolean isLocked = lock.tryLock();
		        if(!isLocked) {
		        	System.out.println(tName + " was blocked, doesn't have the lock haha");
		        	return;
		        }
		        System.out.println(tName + " is doing some work");
		        jp.proceed();
		        lock.unlock();
		    }
		}
}
