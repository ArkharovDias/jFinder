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

    @GetMapping("/list")
    public List<CompanyDto> getCompanies(){
        //TODO
        return null;
    }

    @GetMapping("/list/{query}}")
    public List<CompanyDto> getCompaniesByQuery(@PathVariable("query") String query){
        //TODO
        return null;
    }

    @GetMapping("/company/{company_id}")
    public CompanyDto getCompany(@PathVariable("company_id") Long id){
        //TODO
        return null;
    }

    @PostMapping("/company")
    public void postCompany(@RequestBody CompanyCreationDto company, Authentication authentication){
        //TODO
    }
}
