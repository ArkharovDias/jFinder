package ru.itis.dto.auth;
/*
 * @author Rustem Khairutdinov
 * @group 11-602
 */

import lombok.Builder;
import lombok.Data;

/*
 * Dto приходит с клиента при логине
 */
@Data
@Builder
public class LoginDto {

    private String login;
    private String password;
}
