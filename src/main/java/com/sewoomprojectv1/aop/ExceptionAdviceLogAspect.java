package com.sewoomprojectv1.aop;

import com.sewoomprojectv1.exceptionAdvice.CustomErrorDTO;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class ExceptionAdviceLogAspect {

    @Around("execution(* com.sewoomprojectv1.exceptionAdvice.CustomErrorService.*(..))")
    public Object logAspect(ProceedingJoinPoint joinPoint) throws Throwable {

        Object retVal = joinPoint.proceed();
        CustomErrorDTO error = (CustomErrorDTO) retVal;
        log.error("[Exception] ErrorCode : {} || message : {}", error.getErrCode(),
            error.getMessage());
        return retVal;
    }
}
