package com.sewoomprojectv1.exceptionAdvice;

import com.sewoomprojectv1.domain.common.ResponseDTO;

import com.sewoomprojectv1.service.ResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequiredArgsConstructor
public class CustomExceptionAdvice {

    private final CustomErrorService errorService;
    private final ResponseService responseService;

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ResponseDTO> sopsExceptionHandler(RuntimeException e) {
        return responseService.fail(errorService.getErrorDTO(e));
    }
}
