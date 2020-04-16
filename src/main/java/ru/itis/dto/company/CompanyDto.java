package ru.itis.dto.company;
/*
 * @author Rustem Khairutdinov
 * @group 11-602
 */

import lombok.Builder;
import lombok.Data;
import ru.itis.models.Company;

import java.util.List;
import java.util.stream.Collectors;

/*
 * Dto отправляется на клиент при запросе Компаний(списка и одиночной)
 */
@Data
@Builder
public class CompanyDto {

    private long id;
    private String name;
    private String address;
    private String website;
    private String phone;
    private String information;
    private float rating;
    private int recallsCount;

    public static CompanyDto from(Company company){
        return CompanyDto.builder()
                .id(company.getId())
                .name(company.getName())
                .address(company.getAddress())
                .website(company.getSite())
                .phone(company.getPhoneNumber())
                .information(company.getInformation())
                .rating(company.getRating())
                .recallsCount(company.getRecallsCount())
                .build();
    }

    public static List<CompanyDto> from(List<Company> companies){
        return companies.stream()
                .map(CompanyDto::from)
                .collect(Collectors.toList());
    }
}
