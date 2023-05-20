package com.santechture.security.api.security.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.ResponseEntity;

@Data
@Builder
public class ApiResponse<T> {

    public ApiResponse(int code, String message, T data)
    {
        this.code = code;
        this.message = message;
        this.Data =data;
    }


    public ResponseEntity<ApiResponse<T>> toResponseEntity(){
        return ResponseEntity.ok(ApiResponse.<T>builder()
                .Data(Data)
                .message(message)
                .code(code)
                .build());
    }

    public int code;
    public String message;
    public T Data;
}
