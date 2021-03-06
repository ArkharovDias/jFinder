package ru.itis.dto.item;
/*
 * @author Rustem Khairutdinov
 * @group 11-602
 */

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.models.User;

/*
 * Dto представляет информацию о Студенте, используется в других Dto
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentItemDto {

    private long id;
    private String name;

    public static StudentItemDto from(User user){
        return StudentItemDto.builder()
                .id(user.getId())
                .name(user.getName())
                .build();
    }
}
