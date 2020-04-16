package ru.itis.services;

import ru.itis.models.Vacancy;

import java.util.List;

public interface VacancyService {
    Vacancy findById(Long id);
    List<Vacancy> findAll();
    List<Vacancy> findAllByQuery(String query);
    void save(Vacancy vacancy);
}
