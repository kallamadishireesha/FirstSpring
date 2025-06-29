package com.embarx.FirstSpring.company;

import java.util.List;

import org.springframework.stereotype.Service;
@Service
public interface CompanyService {
    List<Company> getAllCompanies();
    boolean updateCompany(Company company, Long id);
    void createCompany(Company company);
    
 
    
}
