package com.mahindra.finance.model;

import lombok.Getter;
import org.springframework.aot.hint.annotation.RegisterReflectionForBinding;

@Getter
@RegisterReflectionForBinding
public class SuccessResponse<T> {
    private final String status;
    private final T data;
    public SuccessResponse(String status, T data) {
        this.status = status;
        this.data = data;
    }

}
