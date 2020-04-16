package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.models.Company;
import ru.itis.repositories.CompanyRepository;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public Company findById(Long id) {
        return companyRepository.findOne(id);
    }

    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public List<Company> findAllByQuery(String query) {
        //TODO fix QUERY
        return null;
    }

    @Override
    public void save(Company company) {
        companyRepository.save(company);
    }
}
