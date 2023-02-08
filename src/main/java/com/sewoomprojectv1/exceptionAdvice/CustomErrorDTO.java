package com.sewoomprojectv1.exceptionAdvice;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CustomErrorDTO {

    private String errorCode;
    private String message;

    public CustomErrorDTO(RuntimeException e){
        if(isCustomException(e)){
            CustomException exception = (CustomException) e;
            this.errorCode=exception.getError().getCode();
            this.message=exception.getError().getMessage();
        } else {
            this.errorCode="E99";
            this.message=e.getMessage();
        }
    }

    private boolean isCustomException(RuntimeException e) {
        return e instanceof CustomException;
    }
}