package ru.itis.dto.recall;
/*
 * @author Rustem Khairutdinov
 * @group 11-602
 */

import lombok.Builder;
import lombok.Data;
import ru.itis.dto.item.CompanyItemDto;
import ru.itis.dto.item.StudentItemDto;
import ru.itis.models.Recall;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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

    public static RecallDto from(Recall recall){
        return RecallDto.builder()
                .id(recall.getId())
                .information(recall.getInformation())
                .rating(recall.getRating())
                .date(recall.getDate())
                .student(StudentItemDto.from(recall.getUser()))
                .company(CompanyItemDto.from(recall.getCompany()))
                .build();
    }

    public static List<RecallDto> from(List<Recall> recalls){
        return recalls.stream()
                .map(RecallDto::from)
                .collect(Collectors.toList());
    }
}
