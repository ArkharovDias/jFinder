package ru.itis.dto.recall;
/*
 * @author Rustem Khairutdinov
 * @group 11-602
 */

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.dto.item.CompanyItemDto;
import ru.itis.dto.item.StudentItemDto;

/*
 * Dto приходит с клиента при создании Отзыва
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RecallCreationDto {

    private String information;
    private float rating;
    private StudentItemDto student;
    private CompanyItemDto company;
}
