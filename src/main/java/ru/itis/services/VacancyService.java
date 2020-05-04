package ru.itis.services;

import org.springframework.security.core.Authentication;
import ru.itis.dto.vacancy.VacancyCreationDto;
import ru.itis.dto.vacancy.VacancyDto;
import ru.itis.models.Vacancy;

import java.util.List;

public interface VacancyService {
    Vacancy findById(Long id);
    List<Vacancy> findAll();
    List<Vacancy> findAllByQuery(String query);
    void save(VacancyCreationDto vacancyDto, Authentication authentication);
    void save(Vacancy vacancy);
    List<Vacancy> findAllCheckedVacancies();
    List<Vacancy> findAllUncheckedVacancies();
}
