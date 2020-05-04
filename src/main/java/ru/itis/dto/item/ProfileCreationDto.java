package ru.itis.dto.item;
/*
 * @author Rustem Khairutdinov
 * @group 11-602
 */

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * Dto представляет информацию о Профиль, используется в других Dto
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProfileCreationDto {

    private String name;
    private String phone;
}
