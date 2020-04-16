package ru.itis.controllers;
/*
 * @author Rustem Khairutdinov
 * @group 11-602
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import ru.itis.dto.company.CompanyCreationDto;
import ru.itis.dto.company.CompanyDto;
import ru.itis.models.Company;
import ru.itis.services.CompanyService;

import java.util.List;

@RestController
@RequestMapping("companies")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    /*
     * Метод возвращает список компаний
     */
    @GetMapping("/list")
    public List<CompanyDto> getCompanies(){

        List<Company> companies = companyService.findAll();

        return CompanyDto.from(companies);
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

        Company company = companyService.findById(id);

        return CompanyDto.from(company);
    }


    /*
     * Метод создаёт запрос на создание компании
     */
    @PostMapping("/company")
    public void postCompany(@RequestBody CompanyCreationDto company, Authentication authentication){
        //TODO
    }
}
