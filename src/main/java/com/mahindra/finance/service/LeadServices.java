package com.mahindra.finance.service;

import com.mahindra.finance.entity.Lead;
import com.mahindra.finance.model.LeadRequest;
import com.mahindra.finance.repository.LeadRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeadServices {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private LeadRepository leadRepository;
    public Lead createLead(LeadRequest request) {
        //WE can use MapStruct, Model mapper or getter setter or constructor based setup
        Lead lead = modelMapper.map(request, Lead.class);
        System.out.println("lead = " + lead);
        Lead save = leadRepository.save(lead);
        System.out.println("save = " + save);
        return save;
    }

}