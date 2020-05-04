package ru.itis.dto.profile;
/*
 * @author Rustem Khairutdinov
 * @group 11-602
 */

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.dto.item.CompanyItemDto;

/*
 * Dto приходит с клиента при изменении Профиля(списка и одиночного)
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProfileEditingDto {

    private long id;
    private String name;
    private String phone;
    private String vk;
    private String telegram;
    private String facebook;
    private String additionalInformation;
    private CompanyItemDto company;
}
