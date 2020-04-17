package ru.itis.dto.auth;
/*
 * @author Rustem Khairutdinov
 * @group 11-602
 */

import lombok.Builder;
import lombok.Data;
import ru.itis.dto.item.StudentItemDto;

@Data
@Builder
public class AuthenticationDto {

    private StudentItemDto studentItemDto;
    private String jwtToken;
    private String refreshToken; // пока не обязательно
}
