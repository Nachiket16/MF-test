package com.mahindra.finance.model;

import lombok.Data;

import java.util.List;

@Data
public class ErrorRepsonse {
    private String code;
    private List<String> message;
}
