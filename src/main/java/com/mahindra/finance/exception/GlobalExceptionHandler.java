package com.mahindra.finance.exception;

import com.mahindra.finance.model.FailureResponse;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<FailureResponse> handleException(Exception e) {
        return new ResponseEntity<>(new FailureResponse<>("error", "Internal Server Error"), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    FailureResponse onException(MethodArgumentNotValidException methodArgumentNotValidException) {
        List<ApiValidationError> validationErrorsList =
                methodArgumentNotValidException.getAllErrors().stream()
                        .map(
                                objectError -> {
                                    FieldError fieldError = (FieldError) objectError;
                                    return new ApiValidationError(
                                            fieldError.getField(),
                                            fieldError.getDefaultMessage());
                                })
                        .toList();
        FailureResponse failureResponse = new FailureResponse<>("error",validationErrorsList);
        return failureResponse;
    }
    @Data
    @NoArgsConstructor
    static class ApiValidationError {

        private Object code;

        private String message;

        ApiValidationError(String object, String message) {
            this.code = object;
            this.message = message;
        }

        ApiValidationError(String message) {
            this.message = message;
        }
    }
}