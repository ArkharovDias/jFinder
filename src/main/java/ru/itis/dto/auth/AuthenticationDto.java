package ru.itis.dto.auth;
/*
 * @author Rustem Khairutdinov
 * @group 11-602
 */

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.dto.item.StudentItemDto;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationDto {

    private StudentItemDto studentItemDto;
    private String jwtToken;
    private String refreshToken; // пока не обязательно
}
