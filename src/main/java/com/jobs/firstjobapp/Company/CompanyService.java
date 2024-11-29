package com.jobs.firstjobapp.Company;

import java.util.List;

public interface CompanyService {

    public List<Company> getAllCompanies();

    public String addCompany(Company company);

    public Company getCompanyById(int id);

    public boolean updateCompanyById(int id, Company updatedCompany);

    public boolean deleteCompanyById(int id);
}
