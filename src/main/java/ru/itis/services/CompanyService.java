package ru.itis.services;

import org.springframework.security.core.Authentication;
import ru.itis.dto.company.CompanyCreationDto;
import ru.itis.dto.company.CompanyDto;
import ru.itis.models.Company;

import java.util.List;

public interface CompanyService {
    Company findById(Long id);
    List<Company> findAll();
    List<Company> findAllByQuery(String query);
    void save(CompanyCreationDto companyDto, Authentication authentication);
    void save(Company company);
    List<Company> findAllUncheckedCompanies();
    List<Company> findAllCheckedCompanies();
}
