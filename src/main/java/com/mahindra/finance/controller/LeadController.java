package com.mahindra.finance.controller;

import com.mahindra.finance.entity.Lead;
import com.mahindra.finance.model.LeadRequest;
import com.mahindra.finance.model.SuccessResponse;
import com.mahindra.finance.service.LeadServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1")
@Validated
public class LeadController {

    @Autowired
    private LeadServices leadServices;

    @PostMapping("/create")
    public ResponseEntity<?> createLead(@Valid @RequestBody LeadRequest request){
        System.out.println("request = " + request);
        Lead lead = leadServices.createLead(request);
        return new ResponseEntity<>(new SuccessResponse<>("Success","Created Leads Successfully"), HttpStatus.CREATED);
    }

    @GetMapping("/hello")
    public String getLead(){
        return "hello world";
    }

}
