package com.mahindra.finance.service;

import com.mahindra.finance.entity.Lead;
import com.mahindra.finance.model.ErrorResponse;
import com.mahindra.finance.model.FailureResponse;
import com.mahindra.finance.model.LeadRequest;
import com.mahindra.finance.model.SuccessResponse;
import com.mahindra.finance.repository.LeadRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LeadServices {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private LeadRepository leadRepository;
    public ResponseEntity<?> createLead(LeadRequest request) {
        Optional<Lead> presentLead = leadRepository.findById(Integer.valueOf(request.getLeadId()));
        if (!presentLead.isEmpty()){
            List<String> errorMessages = new ArrayList<>();
            errorMessages.add("Lead Already Exists in the database with the lead id");
            ErrorResponse errorResponse = new ErrorResponse("E10010",errorMessages);
            return new ResponseEntity<>(new FailureResponse("error",errorResponse), HttpStatus.CONFLICT);
        }
        Lead lead = modelMapper.map(request, Lead.class);
        Lead save = leadRepository.save(lead);
        return new ResponseEntity<>(new SuccessResponse<>("Success","Created Leads Successfully"), HttpStatus.CREATED);
    }

    public ResponseEntity<?> getByMobileNumber(String mobile) {
        List<Lead> byMobileNumber = leadRepository.findByMobileNumber(mobile);
        if (byMobileNumber.isEmpty()){
            List<String> errorMessages = new ArrayList<>();
            errorMessages.add("No Lead found with the Mobile Number ");
            ErrorResponse errorResponse = new ErrorResponse("E10011",errorMessages);
            return new ResponseEntity<>(new FailureResponse("error",errorResponse), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new SuccessResponse<>("Success",byMobileNumber), HttpStatus.OK);
    }
}