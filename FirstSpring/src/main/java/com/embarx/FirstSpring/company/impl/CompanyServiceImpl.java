package com.embarx.FirstSpring.company.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.embarx.FirstSpring.company.Company;
import com.embarx.FirstSpring.company.CompanyRepository;
import com.embarx.FirstSpring.company.CompanyService;

@Service 
public class CompanyServiceImpl implements CompanyService{

    CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompanies() {
        return  companyRepository.findAll();
        
    }

    @Override
    public boolean updateCompany(Company company, Long id) {
       Optional<Company> companyOptional = companyRepository.findById(id);
            if(companyOptional.isPresent()) {
                Company companyToUpdate = companyOptional.get();
                companyToUpdate.setName(company.getName());
                companyToUpdate.setDescription(company.getDescription());
                companyRepository.save(companyToUpdate);
                return true;
            }
        return false; 
    }

    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);
    }
    
}
