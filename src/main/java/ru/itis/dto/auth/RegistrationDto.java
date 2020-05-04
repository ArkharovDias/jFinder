package ru.itis.dto.auth;
/*
 * @author Rustem Khairutdinov
 * @group 11-602
 */

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.dto.item.ProfileCreationDto;

/*
 * Dto приходит с клиента при регистрации
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationDto {

    private String login;
    private String password;
    private String passwordConfirm;
    private ProfileCreationDto profile;
}
