package com.sewoomprojectv1.domain.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ResponseDTO  {
    private String status;
    private Object data;
}
