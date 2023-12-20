package com.mahindra.finance.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class LeadRequest {
    @NotBlank
    @Pattern(regexp = "^(?=.*\\d)[a-zA-Z\\d\\s]*$\n")
    private String leadId;
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z]+$")
    private String firstName;
    @Pattern(regexp = "^[a-zA-Z]+$")
    private String middleName;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z]+$")
    private String lastName;

    @NotBlank
    @Pattern(regexp = "^[6-9]\\d{9}$")
    private String mobileNumber;


    @NotBlank
    @Pattern(regexp = "\\b(?:male|female|others)\\b")
    private String gender;

    @NotBlank
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String DOB;

    @Email
    private String email;
}
