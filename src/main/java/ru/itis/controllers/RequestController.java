package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import ru.itis.dto.company.CompanyDto;
import ru.itis.dto.recall.RecallDto;
import ru.itis.dto.vacancy.VacancyDto;
import ru.itis.models.Company;
import ru.itis.models.Recall;
import ru.itis.models.User;
import ru.itis.models.Vacancy;
import ru.itis.services.CompanyService;
import ru.itis.services.RecallService;
import ru.itis.services.VacancyService;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("requests")
public class RequestController {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private VacancyService vacancyService;

    @Autowired
    private RecallService recallService;

    @GetMapping("/companies/list")
    public List<CompanyDto> getCompanies(){
        return CompanyDto.from(companyService.findAllUncheckedCompanies());
    }

    @GetMapping("/vacancies/list")
    public List<VacancyDto> getVacancies(){
        return VacancyDto.from(vacancyService.findAllUncheckedVacancies());
    }

    @GetMapping("/recalls/list")
    public List<RecallDto> getRecalls(){
        return RecallDto.from(recallService.findAllUncheckedRecalls());
    }


    @Transactional
    @PostMapping("/success/{entity}/{id}")
    public void postEntity(@PathVariable("entity") String entityName, @PathVariable("id") Long id) throws ParseException {
        switch (entityName){
            case "company":
                Company company = companyService.findById(id);
                company.setChecked(true);
                companyService.save(company);
                break;
            case "vacancy":
                Vacancy vacancy = vacancyService.findById(id);
                vacancy.setChecked(true);
                vacancyService.save(vacancy);
                break;
            case "recall":
                Recall recall = recallService.getRecallById(id);
                recall.setChecked(true);
                recallService.save(recall);

                Company companyFromRecall = recall.getCompany();

                List<Recall> recalls = recallService.findReacallsByCompanyId(companyFromRecall.getId());

                float rating = recalls.stream()
                        .map(n -> n.getRating())
                        .reduce((float)0, (a, b) -> a + b)/recalls.size();

                DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance();
                symbols.setDecimalSeparator('.');
                DecimalFormat format = new DecimalFormat("#.##", symbols);
                companyFromRecall.setRating(format.parse(format.format(rating)).floatValue());
                companyFromRecall.setRecallsCount(recalls.size());

                companyService.save(companyFromRecall);

                break;
        }
    }


}
