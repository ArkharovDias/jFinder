package ru.itis.dto.auth;
/*
 * @author Rustem Khairutdinov
 * @group 11-602
 */

import lombok.Builder;
import lombok.Data;
import ru.itis.dto.item.ProfileCreationDto;

/*
 * Dto приходит с клиента при регистрации
 */
@Data
@Builder
public class RegistrationDto {

    private String login;
    private String password;
    private String passwordConfirm;
    private ProfileCreationDto profile;
}
