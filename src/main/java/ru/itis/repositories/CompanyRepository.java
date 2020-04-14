package ru.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.models.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
