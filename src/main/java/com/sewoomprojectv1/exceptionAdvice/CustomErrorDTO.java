package com.sewoomprojectv1.exceptionAdvice;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CustomErrorDTO {

    private String errCode;
    private String message;

    public CustomErrorDTO(CustomException e) {
        this.errCode = e.getError().getCode();
        this.message = e.getError().getMessage();
    }

    public CustomErrorDTO(String errCode, RuntimeException e) {
        this.errCode = errCode;
        this.message = e.getMessage();
    }
}