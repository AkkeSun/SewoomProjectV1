package com.sewoomprojectv1.service;

import com.sewoomprojectv1.domain.common.ResponseDTO;
import org.springframework.http.ResponseEntity;

public interface ResponseService {
    ResponseEntity<ResponseDTO> success(Object responseObj);
    ResponseEntity<ResponseDTO> fail(Object responseObj);
}
