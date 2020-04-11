package ru.itis.dto.vacancy;
/*
 * @author Rustem Khairutdinov
 * @group 11-602
 */

import lombok.Builder;
import lombok.Data;
import ru.itis.dto.item.CompanyItemDto;
import ru.itis.dto.item.StudentItemDto;

import java.util.Date;

/*
 * Dto приходит с клиента при создании Вакансии
 */
@Data
@Builder
public class VacancyCreationDto {

    private String name;
    private String information;
    private int salary;
    private Date date;
    private CompanyItemDto company;
    private StudentItemDto student;
}
