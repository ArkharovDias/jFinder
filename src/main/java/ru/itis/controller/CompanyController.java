package ru.itis.controller;
/*
 * @author Rustem Khairutdinov
 * @group 11-602
 */

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import ru.itis.dto.company.CompanyCreationDto;
import ru.itis.dto.company.CompanyDto;

import java.util.List;

@RestController("/companies")
public class CompanyController {

    /*
     * Метод возвращает список компаний
     */
    @GetMapping("/list")
    public List<CompanyDto> getCompanies(){
        //TODO
        return null;
    }

    /*
     * Метод возвращает список компаний с учетом {query} по имени компании
     */
    @GetMapping("/list/{query}}")
    public List<CompanyDto> getCompaniesByQuery(@PathVariable("query") String query){
        //TODO
        return null;
    }

    /*
     * Метод возвращает компанию по {company_id}
     */
    @GetMapping("/company/{company_id}")
    public CompanyDto getCompany(@PathVariable("company_id") Long id){
        //TODO
        return null;
    }


    /*
     * Метод создаёт запрос на создание компании
     */
    @PostMapping("/company")
    public void postCompany(@RequestBody CompanyCreationDto company, Authentication authentication){
        //TODO
    }
}
