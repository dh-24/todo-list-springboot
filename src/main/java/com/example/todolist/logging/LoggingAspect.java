package com.example.todolist.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    // Logs method entry – every method in your controller & service layers
    @Before("execution(* com.example.todolist..*(..))")
    public void logMethodEntry(JoinPoint joinPoint) {
        logger.info("ENTER: {}.{}() with arguments = {}",
                joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(),
                joinPoint.getArgs());
    }

    // Logs normal method exit
    @AfterReturning(pointcut = "execution(* com.example.todolist..*(..))", returning = "result")
    public void logMethodExit(JoinPoint joinPoint, Object result) {
        logger.info("EXIT: {}.{}() with result = {}",
                joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(),
                result);
    }

    // Logs exceptions
    @AfterThrowing(pointcut = "execution(* com.example.todolist..*(..))", throwing = "ex")
    public void logExceptions(JoinPoint joinPoint, Exception ex) {
        logger.error("EXCEPTION in {}.{}() with message = {}",
                joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(),
                ex.getMessage(),
                ex);
    }
}
