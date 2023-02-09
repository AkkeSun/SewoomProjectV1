package com.sewoomprojectv1.exceptionAdvice;

public interface CustomErrorService {

    CustomErrorDTO getCustomErr(CustomException e);

    CustomErrorDTO getNPEError(NumberFormatException e);

    CustomErrorDTO getNPEErr(NullPointerException e);

    CustomErrorDTO getIOBErr(IndexOutOfBoundsException e);

    CustomErrorDTO getCCEError(ClassCastException e);

}
