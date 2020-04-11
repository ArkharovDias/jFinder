package ru.itis.dto.item;
/*
 * @author Rustem Khairutdinov
 * @group 11-602
 */

import lombok.Builder;
import lombok.Data;

/*
 * Dto представляет информацию о Профиль, используется в других Dto
 */
@Data
@Builder
public class ProfileCreationDto {

    private String name;
    private String phone;
}
