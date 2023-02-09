package com.sewoomprojectv1.exceptionAdvice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CustomErrorServiceImpl implements CustomErrorService {

    private final String NUMBER_FORMAT_EXCEPTION_CODE = "NFE";
    private final String NULL_POINT_EXCEPTION_CODE = "NPE";
    private final String INDEX_OUT_OF_BOUNDS_EXCEPTION_CODE = "IOB";
    private final String CLASS_CAST_EXCEPTION_CODE = "CCE";

    @Override
    public CustomErrorDTO getCustomErr(CustomException e) {
        return new CustomErrorDTO(e);
    }

    @Override
    public CustomErrorDTO getNPEError(NumberFormatException e) {
        return new CustomErrorDTO(NUMBER_FORMAT_EXCEPTION_CODE, e);
    }

    @Override
    public CustomErrorDTO getNPEErr(NullPointerException e) {
        return new CustomErrorDTO(NULL_POINT_EXCEPTION_CODE, e);
    }

    @Override
    public CustomErrorDTO getIOBErr(IndexOutOfBoundsException e) {
        return new CustomErrorDTO(INDEX_OUT_OF_BOUNDS_EXCEPTION_CODE, e);

    }

    @Override
    public CustomErrorDTO getCCEError(ClassCastException e) {
        return new CustomErrorDTO(CLASS_CAST_EXCEPTION_CODE, e);
    }
}
