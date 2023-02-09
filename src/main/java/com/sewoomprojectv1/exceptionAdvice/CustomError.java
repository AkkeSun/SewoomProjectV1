package com.sewoomprojectv1.exceptionAdvice;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CustomError {

    INVALID_PARAMETER("CE_01", "Invalid Parameter");

    private final String code;
    private final String message;
}
