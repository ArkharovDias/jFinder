package ru.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.models.Recall;

public interface RecallRepository extends JpaRepository<Recall, Long> {
}
