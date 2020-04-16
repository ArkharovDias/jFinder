package ru.itis.services;

import ru.itis.models.Company;

import java.util.List;

public interface CompanyService {
    Company findById(Long id);
    List<Company> findAll();
    List<Company> findAllByQuery(String query);
    void save(Company company);
}
