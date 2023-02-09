package com.sewoomprojectv1.domain.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class ResponseDTO  {
    private boolean success;
    private Object data;
}
