package com.mahindra.finance.model;

import lombok.Data;
import lombok.Getter;
import org.springframework.aot.hint.annotation.RegisterReflectionForBinding;

@Getter
@RegisterReflectionForBinding
@Data
public class FailureResponse<T> {
    private final String status;
    private final T errorResponse;
    public FailureResponse(String status, T data) {
        this.status = status;
        this.errorResponse = data;
    }
}
