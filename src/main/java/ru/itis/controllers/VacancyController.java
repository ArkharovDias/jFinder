package ru.itis.controllers;
/*
 * @author Rustem Khairutdinov
 * @group 11-602
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import ru.itis.dto.vacancy.VacancyCreationDto;
import ru.itis.dto.vacancy.VacancyDto;
import ru.itis.models.Vacancy;
import ru.itis.services.VacancyService;

import java.util.List;

@RestController
@RequestMapping("vacancy")
public class VacancyController {

    @Autowired
    private VacancyService vacancyService;

    /*
     * Метод возвращает список вакансий
     */
    @GetMapping("/list")
    public List<VacancyDto> getVacancies(){

        List<Vacancy> vacancies = vacancyService.findAll();

        return VacancyDto.from(vacancies);
    }

    /*
     * Метод возвращает список вакансий с учетом {query} по названию вакансии
     */
    @GetMapping("/list/{query}}")
    public List<VacancyDto> getVacanciesByQuery(@PathVariable("query") String query){
        //TODO
        return null;
    }

    /*
     * Метод возвращает вакансию по {vacancy_id}
     */
    @GetMapping("/vacancy/{vacancy_id}")
    public VacancyDto getVacancy(@PathVariable("vacancy_id") Long id){

        Vacancy vacancy = vacancyService.findById(id);

        return VacancyDto.from(vacancy);
    }


    /*
     * Метод создаёт запрос на создание вакансии
     */
    @PostMapping("/vacancy")
    public void postRecall(@RequestBody VacancyCreationDto vacancy, Authentication authentication){
        //TODO
    }
}
