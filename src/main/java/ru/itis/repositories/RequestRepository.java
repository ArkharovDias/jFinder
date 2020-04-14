package ru.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.models.Request;

public interface RequestRepository extends JpaRepository<Request, Long> {
}
