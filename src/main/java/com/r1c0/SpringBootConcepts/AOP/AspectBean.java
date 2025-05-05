package com.r1c0.SpringBootConcepts.AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectBean {

    // TODO - * -> can be replaced with any
    // TODO - .. -> matches zero or more items

    /**
     *
     * Pointcut expressions:
     *      execution - applied at method execution
     *      within - applied at class execution
     *      @annotation - applied at method annotation
     *      @within - applied at class annotation
     *      @args - applied at method arguments
     *
     */


    // TODO - Gets called before the execution of the method, Works on method level
    @Before("execution(public * com.r1c0.SpringBootConcepts.AOP.AspectService.*(..))")
    public void beforeAdvice() {
        System.out.println("A public method in the AspectService class is about to be called.");
    }

    // TODO - Gets called after the execution of the method is completed, Can't be used to catch exceptions as it gets triggered after the method execution, Works on method level
    @After("execution(public * com.r1c0.SpringBootConcepts..getServiceMessage(..))")
    public void afterAdvice() {
        System.out.println("A public method in the AspectService class has been called.");
    }

    // TODO - Gets called before and after the execution of the method, Can be used to catch exceptions, Works on method level
    @Around("execution(public * com.r1c0.SpringBootConcepts.AOP.*.getServiceMessage(*))")
    public void aroundAdvice(org.aspectj.lang.ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Around advice: Before method execution.");
        try{
            // Proceed with the method execution
            joinPoint.proceed();
        } catch (Throwable throwable) {
            System.out.println("Around advice: Exception caught.");
            throw throwable; // Rethrow the exception
        }
        System.out.println("Around advice: After method execution.");
    }

    // TODO - Gets called before execution of each method in the AspectService class, Works on class level
    @Before("within(com.r1c0.SpringBootConcepts.AOP.AspectService)")
    public void withinAdvice() {
        System.out.println("Within advice: A method in AspectService is about to be called.");
    }

    // TODO - Gets called after execution of each method in the class annotated with @Service annotation, Works on class level
    @After("@within(org.springframework.stereotype.Service)")
    public void afterWithinAdvice() {
        System.out.println("After within advice: A method in AspectService has been called.");
    }

    // TODO - Gets called before execution of each method annotated with @GetMapping annotation, Works on class level
    @Before("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void beforeAnnotationAdvice() {
        System.out.println("Before annotation advice: A method annotated with @GetMapping is about to be called.");
    }

    // TODO - Gets called before execution of each method annotated with @PostMapping annotation, Works on class level
    // TODO - JoinPoint is used to get the method arguments
    @Before("@annotation(org.springframework.web.bind.annotation.PostMapping)")
    public void beforePostMappingAdvice(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();

        System.out.println("Received request for " + joinPoint.getSignature() + " with arguments:");
        for (Object arg : args) {
            System.out.println(arg);
        }
        System.out.println("Before annotation advice: A method annotated with @PostMapping is about to be called.");
    }

}
