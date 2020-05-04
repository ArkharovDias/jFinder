package ru.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.models.Recall;

import java.util.List;

public interface RecallRepository extends JpaRepository<Recall, Long> {
    List<Recall> findRecallsByCheckedTrue();
    List<Recall> findRecallsByCheckedFalse();
    List<Recall> findRecallsByCompanyId(Long id);
}
