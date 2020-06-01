package ru.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.models.RateValue;

public interface RateRepository extends JpaRepository<RateValue, Long> {
}
