package com.sewoomprojectv1.exceptionAdvice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CustomErrorServiceImpl implements CustomErrorService {

    @Override
    public CustomErrorDTO getErrorDTO(RuntimeException e) {
        CustomErrorDTO error = new CustomErrorDTO(e);
        log.error("[Exception] ErrorCode : {} || message : {}", error.getErrorCode(), error.getMessage());
        return error;
    }
}
