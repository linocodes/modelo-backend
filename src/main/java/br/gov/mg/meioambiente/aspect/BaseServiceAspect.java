package br.gov.mg.meioambiente.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BaseServiceAspect {

	@Before("execution(public * br.gov.mg.meioambiente.persistence.service.*Service.*(..))")	
//	@Before(value = "execution(*  br.gov.mg.meioambiente.persistence.service.*(..))")
	public void beforeAdvice(JoinPoint joinPoint) {
		System.out.println("Before method:" + joinPoint.getSignature());

		//System.out.println("Creating Employee with name - " + name + " and id - " + empId);
	}

	@After("execution(public * br.gov.mg.meioambiente.persistence.service.*Service.*(..))")	
	public void afterAdvice(JoinPoint joinPoint) {
		System.out.println("After method:" + joinPoint.getSignature());

		//System.out.println("Successfully created Employee with name - " + name + " and id - " + empId);
	}
}