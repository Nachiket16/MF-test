package com.mahindra.finance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Lead {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer leadId;
    private String firstName;
    private String middleName;
    private String LastName;
    private String mobileNumber;
//    Not using enum as need to define in db first but ideally should be enum
//    private Gender gender;
    private String gender;
    private LocalDate dob;
    private String email;

}
