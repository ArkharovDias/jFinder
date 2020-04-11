package ru.itis.dto.profile;
/*
 * @author Rustem Khairutdinov
 * @group 11-602
 */

import lombok.Builder;
import lombok.Data;
import ru.itis.dto.item.CompanyItemDto;

/*
 * Dto отправляется на клиент при запросе Компании
 */
@Data
@Builder
public class ProfileDto {

    private long id;
    private String name;
    private String phone;
    private String vk;
    private String telegram;
    private String facebook;
    private String additionalInformation;
    private CompanyItemDto company;
}
