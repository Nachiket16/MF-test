package com.mahindra.finance.repository;

import com.mahindra.finance.entity.Lead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeadRepository extends JpaRepository<Lead,Integer> {
    List<Lead> findByMobileNumber(String mobile);
}
