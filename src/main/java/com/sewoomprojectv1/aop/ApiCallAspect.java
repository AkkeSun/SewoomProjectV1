package com.sewoomprojectv1.aop;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sewoomprojectv1.domain.common.ApiCallLogDTO;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class ApiCallAspect {

    @Around("execution(* com.sewoomprojectv1.controller.*.*(..))")
    public Object apiCall(ProceedingJoinPoint pjp) throws Throwable {
        ApiCallLogDTO api = new ApiCallLogDTO(getRequestData(pjp));
        printApiCallRequestLog(api);

        //TODO: DB Save
        Object response = pjp.proceed();

        printApiCallResponseLog(api, response);
        return response;
    }

    private void printApiCallRequestLog(ApiCallLogDTO api) {
        log.info("[API CALL]   =>   ({}) {}  =  {}", api.getMethod(), api.getUrl(),
            api.getRequestData());
    }

    private void printApiCallResponseLog(ApiCallLogDTO api, Object response)
        throws JsonProcessingException {
        log.info("[API CALL]   <=   ({}) {}  =  {}", api.getMethod(), api.getUrl(),
            getResponseData(response));
    }

    private String getRequestData(ProceedingJoinPoint joinPoint) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        if (joinPoint.getArgs().length == 1) {
            return mapper.writeValueAsString(joinPoint.getArgs()[0]);
        }
        return mapper.writeValueAsString(joinPoint.getArgs());
    }

    private String getResponseData(Object response) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(((ResponseEntity<?>) response).getBody());
    }
}
