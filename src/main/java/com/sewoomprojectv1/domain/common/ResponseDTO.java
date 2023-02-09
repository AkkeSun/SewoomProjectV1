package com.sewoomprojectv1.domain.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ResponseDTO  {
    private boolean success;
    private Object data;
}
