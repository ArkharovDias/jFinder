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

import java.util.List;

@RestController
@RequestMapping("vacancy")
public class VacancyController {

    /*
     * Метод возвращает список вакансий
     */
    @GetMapping("/list")
    public List<VacancyDto> getVacancies(){
        //TODO
        return null;
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
        //TODO
        return null;
    }


    /*
     * Метод создаёт запрос на создание вакансии
     */
    @PostMapping("/vacancy")
    public void postRecall(@RequestBody VacancyCreationDto vacancy, Authentication authentication){
        //TODO
    }
}
