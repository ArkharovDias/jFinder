package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import ru.itis.dto.vacancy.VacancyCreationDto;
import ru.itis.dto.vacancy.VacancyDto;
import ru.itis.models.Company;
import ru.itis.models.Request;
import ru.itis.models.User;
import ru.itis.models.Vacancy;
import ru.itis.repositories.CompanyRepository;
import ru.itis.repositories.RequestRepository;
import ru.itis.repositories.UserRepository;
import ru.itis.repositories.VacancyRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VacancyServiceImpl implements VacancyService {

    @Autowired
    private VacancyRepository vacancyRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private RequestRepository requestRepository;

    @Override
    public Vacancy findById(Long id) {
        return vacancyRepository.findOne(id);
    }

    @Override
    public List<Vacancy> findAll() {
        return vacancyRepository.findAll();
    }

    @Override
    public List<Vacancy> findAllByQuery(String query) {
        return vacancyRepository.findVacanciesByCheckedTrue().stream()
                .filter(n->n.getName().startsWith(query)||n.getInformation().contains(query)||n.getName().contains(query))
                //.filter(n->n.getName().startsWith(query))
                .collect(Collectors.toList());
    }

    @Override
    public void save(VacancyCreationDto vacancyDto, Authentication authentication) {

        User user = userRepository.findOne(vacancyDto.getStudent().getId());

        Company company = companyRepository.findOne(vacancyDto.getCompany().getId());

        Vacancy vacancy = Vacancy.builder()
                .name(vacancyDto.getName())
                .salary(vacancyDto.getSalary())
                .user(user)
                .company(company)
                .checked(false)
                .date(vacancyDto.getDate())
                .information(vacancyDto.getInformation())
                .build();

        vacancyRepository.save(vacancy);

        Request request = Request.builder()
                .entityId(vacancy.getId())
                .user(user)
                .type("vacancy")
                .build();

        requestRepository.save(request);
    }

    @Override
    public void save(Vacancy vacancy) {
        vacancyRepository.save(vacancy);
    }

    @Override
    public List<Vacancy> findAllCheckedVacancies() {
        return vacancyRepository.findVacanciesByCheckedTrue();
    }

    @Override
    public List<Vacancy> findAllUncheckedVacancies() {
        return vacancyRepository.findVacanciesByCheckedFalse();
    }
}
