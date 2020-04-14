package ru.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.models.Vacancy;

public interface VacancyRepository extends JpaRepository<Vacancy, Long> {
}
