package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import ru.itis.dto.recall.RecallCreationDto;
import ru.itis.models.Company;
import ru.itis.models.Recall;
import ru.itis.models.Request;
import ru.itis.models.User;
import ru.itis.repositories.CompanyRepository;
import ru.itis.repositories.RecallRepository;
import ru.itis.repositories.RequestRepository;
import ru.itis.repositories.UserRepository;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecallServiceImpl implements RecallService {

    @Autowired
    private RecallRepository recallRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private RequestRepository requestRepository;

    @Override
    public List<Recall> getRecalls() {
        return recallRepository.findAll();
    }

    @Override
    public List<Recall> getRecallsByQuery(String query) {
        return recallRepository.findRecallsByCheckedTrue().stream()
                .filter(n->n.getInformation().contains(query))
                .collect(Collectors.toList());
    }

    @Override
    public Recall getRecallById(Long id) {
        return recallRepository.findOne(id);
    }

    @Override
    public void save(RecallCreationDto recallCreationDto, Authentication authentication) {

        User user = userRepository.findOne(recallCreationDto.getStudent().getId());

        Company company = companyRepository.findOne(recallCreationDto.getCompany().getId());

        Recall recall = Recall.builder()
                .information(recallCreationDto.getInformation())
                .rating(recallCreationDto.getRating())
                .date(new Date())
                .checked(false)
                .user(user)
                .company(company)
                .build();

        recallRepository.save(recall);

        Request request = Request.builder()
                .entityId(recall.getId())
                .type("recall")
                .user(user)
                .build();

        requestRepository.save(request);
    }

    @Override
    public void save(Recall recall) {
        recallRepository.save(recall);
    }

    @Override
    public List<Recall> findAllCheckedRecalls() {
        return recallRepository.findRecallsByCheckedTrue();
    }

    @Override
    public List<Recall> findAllUncheckedRecalls() {
        return recallRepository.findRecallsByCheckedFalse();
    }

    @Override
    public List<Recall> findReacallsByCompanyId(Long id) {
        return recallRepository.findRecallsByCompanyId(id);
    }
}
