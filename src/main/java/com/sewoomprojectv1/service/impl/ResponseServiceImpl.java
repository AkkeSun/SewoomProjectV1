package com.sewoomprojectv1.service.impl;

import com.sewoomprojectv1.domain.common.ResponseDTO;
import com.sewoomprojectv1.service.ResponseService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ResponseServiceImpl implements ResponseService {

    @Override
    public ResponseEntity<ResponseDTO> success(Object responseObj) {
        return getResponse(true, responseObj);
    }

    @Override
    public ResponseEntity<ResponseDTO> fail(Object responseObj) {
        return getResponse(false, responseObj);
    }

    private ResponseEntity<ResponseDTO> getResponse(boolean isSuccess, Object responseObj) {
        return ResponseEntity.ok(new ResponseDTO(isSuccess, responseObj));
    }

}
