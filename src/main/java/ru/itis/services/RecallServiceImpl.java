package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.models.Recall;
import ru.itis.repositories.RecallRepository;

import java.util.List;

@Service
public class RecallServiceImpl implements RecallService {

    @Autowired
    private RecallRepository recallRepository;

    @Override
    public List<Recall> getRecalls() {
        return recallRepository.findAll();
    }

    @Override
    public List<Recall> getRecallsByQuery(String query) {

        //TODO fix QUERY
        return null;
    }

    @Override
    public Recall getRecallById(Long id) {
        return recallRepository.findOne(id);
    }

    @Override
    public void save(Recall recall) {
        recallRepository.save(recall);
    }
}
