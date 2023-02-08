package com.sewoomprojectv1.exceptionAdvice;

public interface CustomErrorService {

    CustomErrorDTO getErrorDTO(RuntimeException e);
}
