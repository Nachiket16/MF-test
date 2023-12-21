package com.mahindra.finance.controller;

import com.mahindra.finance.model.LeadRequest;
import com.mahindra.finance.service.LeadServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
        return leadServices.createLead(request);
    }

    @GetMapping("/getByPhone/{mobile}")
    public ResponseEntity<?> getLeadByMobileNumber(@PathVariable String mobile) {
        return leadServices.getByMobileNumber(mobile);
    }

}
