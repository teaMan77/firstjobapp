package com.jobs.firstjobapp.Company.impl;

import com.jobs.firstjobapp.Company.Company;
import com.jobs.firstjobapp.Company.CompanyRepository;
import com.jobs.firstjobapp.Company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public String addCompany(Company company) {
        companyRepository.save(company);
        return "Company added successfully!";
    }

    @Override
    public Company getCompanyById(int id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public boolean updateCompanyById(int id, Company updatedCompany) {
        Optional<Company> companyToUpdate = companyRepository.findById(id);
        if (companyToUpdate.isPresent()) {
            Company company = companyToUpdate.get();
            company.setDescription(updatedCompany.getDescription());
            company.setName(updatedCompany.getName());
            company.setJobs(updatedCompany.getJobs());
            companyRepository.save(company);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteCompanyById(int id) {
        if (companyRepository.existsById(id)) {
            companyRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
