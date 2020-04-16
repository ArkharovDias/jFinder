package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.models.Vacancy;
import ru.itis.repositories.VacancyRepository;

import java.util.List;

@Service
public class VacancyServiceImpl implements VacancyService {

    @Autowired
    private VacancyRepository vacancyRepository;

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

        //TODO fix QUERY
        return null;
    }

    @Override
    public void save(Vacancy vacancy) {
        vacancyRepository.save(vacancy);
    }
}
