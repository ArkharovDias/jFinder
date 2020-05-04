package ru.itis.services;

import org.springframework.security.core.Authentication;
import ru.itis.dto.recall.RecallCreationDto;
import ru.itis.models.Recall;

import java.util.List;

public interface RecallService {
    List<Recall> getRecalls();
    List<Recall> getRecallsByQuery(String query);
    Recall getRecallById(Long id);
    void save(RecallCreationDto recallCreationDto, Authentication authenticationa);
    void save(Recall recall);
    List<Recall> findAllCheckedRecalls();
    List<Recall> findAllUncheckedRecalls();
    List<Recall> findReacallsByCompanyId(Long id);
}
