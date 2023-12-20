package com.mahindra.finance.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class LeadRequest {
    @NotBlank
    @Pattern(regexp = "^\\d+$")
    private String leadId;
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z]+$",message = "contain Alphabets, no spaces and mandatory")
    private String firstName;

    @Pattern(regexp = "^[a-zA-Z]+$",message = "contain Alphabets, no spaces")
    private String middleName;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z]+$",message = "contain Alphabets, no spaces and mandatory")
    private String lastName;

    @NotBlank
    @Pattern(regexp = "^[6-9]\\d{9}$",message = "Mobile first digit should be greater than 5")
    private String mobileNumber;


    @NotBlank
    @Pattern(regexp = "\\b(?:male|female|others|Male|Female|Other)\\b",message = "Specified value accepted for gender")
    private String gender;

    @NotBlank
    @Pattern(regexp = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$",message = "Specified value accepted for dob dd/mm/yyyy")
    private String dob;

    @Email
    private String email;
}
