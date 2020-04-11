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
}
