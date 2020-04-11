package ru.itis.dto.recall;
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
 * Dto отправляется на клиент при запросе Отзыва(списка и одиночного)
 */
@Data
@Builder
public class RecallDto {

    private long id;
    private String information;
    private float rating;
    private Date date;
    private StudentItemDto student;
    private CompanyItemDto company;
}
