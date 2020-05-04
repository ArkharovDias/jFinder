package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import ru.itis.dto.company.CompanyCreationDto;
import ru.itis.dto.company.CompanyDto;
import ru.itis.models.Company;
import ru.itis.models.Request;
import ru.itis.repositories.CompanyRepository;
import ru.itis.repositories.RequestRepository;
import ru.itis.repositories.UserRepository;
import ru.itis.security.details.UserDetailsImpl;

import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RequestRepository requestRepository;

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

        //String pattern = "^".concat(query).concat(".*$");

        return companyRepository.findCompaniesByCheckedTrue().stream()
                //.filter(n->n.getName().matches(pattern))
                .filter(n->n.getName().startsWith(query))
                .collect(Collectors.toList());
    }

    @Override
    public void save(CompanyCreationDto companyDto, Authentication authentication) {

        Company company = Company.builder()
                .name(companyDto.getName())
                .address(companyDto.getAddress())
                .site(companyDto.getWebsite())
                .phoneNumber(companyDto.getPhone())
                .information(companyDto.getInformation())
                .rating(0)
                .recallsCount(0)
                .checked(false)
                .build();

        companyRepository.save(company);

        Request request = Request.builder()
                .entityId(company.getId())
                .type("company")
                .user(userRepository.getUserByLogin(authentication.getPrincipal().toString()).get())
                .build();

        requestRepository.save(request);
    }

    @Override
    public void save(Company company) {
        companyRepository.save(company);
    }

    @Override
    public List<Company> findAllUncheckedCompanies() {
        return companyRepository.findCompaniesByCheckedFalse();
    }

    @Override
    public List<Company> findAllCheckedCompanies() {
        return companyRepository.findCompaniesByCheckedTrue();
    }
}
