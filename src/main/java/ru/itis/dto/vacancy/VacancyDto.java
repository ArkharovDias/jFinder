package ru.itis.dto.vacancy;
/*
 * @author Rustem Khairutdinov
 * @group 11-602
 */

import lombok.Builder;
import lombok.Data;
import ru.itis.dto.item.CompanyItemDto;
import ru.itis.dto.item.StudentItemDto;
import ru.itis.models.Vacancy;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/*
 * Dto отправляется на клиент при запросе Вакансии(списка и одиночной)
 */
@Data
@Builder
public class VacancyDto {

    private long id;
    private String name;
    private String information;
    private float rating;
    private int recallsCount;
    private int salary;
    private Date date;
    private CompanyItemDto company;
    private StudentItemDto student;

    public static VacancyDto from(Vacancy vacancy){
        return VacancyDto.builder()
                .id(vacancy.getId())
                .name(vacancy.getName())
                .information(vacancy.getInformation())
                //.rating(vacancy.)TODO ask Rustem
                //.recallsCount()TODO ask Rustem
                .salary(vacancy.getSalary())
                .date(vacancy.getDate())
                .company(CompanyItemDto.from(vacancy.getCompany()))
                .student(StudentItemDto.from(vacancy.getUser()))
                .build();
    }

    public static List<VacancyDto> from(List<Vacancy> vacancies){
        return vacancies.stream()
                .map(VacancyDto::from)
                .collect(Collectors.toList());
    }
}
