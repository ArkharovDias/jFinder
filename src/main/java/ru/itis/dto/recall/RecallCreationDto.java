package ru.itis.dto.recall;
/*
 * @author Rustem Khairutdinov
 * @group 11-602
 */

import lombok.Builder;
import lombok.Data;
import ru.itis.dto.item.CompanyItemDto;
import ru.itis.dto.item.StudentItemDto;

/*
 * Dto приходит с клиента при создании Отзыва
 */
@Data
@Builder
public class RecallCreationDto {

    private String information;
    private float rating;
    private StudentItemDto student;
    private CompanyItemDto company;
}
