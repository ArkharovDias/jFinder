package ru.itis.services;

import ru.itis.models.Recall;

import java.util.List;

public interface RecallService {
    List<Recall> getRecalls();
    List<Recall> getRecallsByQuery(String query);
    Recall getRecallById(Long id);
    void save(Recall recall);
}
