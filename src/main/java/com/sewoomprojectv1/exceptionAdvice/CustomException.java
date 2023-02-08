package com.sewoomprojectv1.exceptionAdvice;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CustomException extends RuntimeException {
    private final CustomError error;
}
