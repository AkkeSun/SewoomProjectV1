package com.sewoomprojectv1.domain.common;

import com.sewoomprojectv1.domain.user.Token;
import javax.servlet.http.HttpServletRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Getter
@Setter
@NoArgsConstructor
public class ApiCallLogDTO {

    private String url;
    private String method;
    private Token token;
    private String requestData;

    public ApiCallLogDTO(String requestData) {
        HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        this.url = req.getRequestURL().toString();
        this.method = req.getMethod();
        this.token = Token.builder().accessToken(req.getHeader("ACCESS-TOKEN"))
            .refreshToken(req.getHeader("REFRESH-TOKEN"))
            .build();
        this.requestData = requestData;
    }
}
