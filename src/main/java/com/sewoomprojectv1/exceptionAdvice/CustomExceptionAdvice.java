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

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ResponseDTO> customExceptionHandler(CustomException e) {
        return responseService.fail(errorService.getCustomErr(e));
    }

    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<ResponseDTO> numberFormatExceptionAdvice(NumberFormatException e) {
        return responseService.fail(errorService.getNPEError(e));
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ResponseDTO> nullPointerExceptionAdvice(NullPointerException e) {
        return responseService.fail(errorService.getNPEErr(e));
    }

    @ExceptionHandler(IndexOutOfBoundsException.class)
    public ResponseEntity<ResponseDTO> indexOutOfBoundsExceptionAdvice(
        IndexOutOfBoundsException e) {
        return responseService.fail(errorService.getIOBErr(e));
    }

    @ExceptionHandler(ClassCastException.class)
    public ResponseEntity<ResponseDTO> classCastExceptionAdvice(ClassCastException e) {
        return responseService.fail(errorService.getCCEError(e));
    }

}
