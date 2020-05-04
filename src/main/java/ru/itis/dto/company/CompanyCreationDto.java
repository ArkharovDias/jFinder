package ru.itis.dto.company;
/*
 * @author Rustem Khairutdinov
 * @group 11-602
 */

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * Dto приходит с клиента при создании Компании
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompanyCreationDto {

    private String name;
    private String address;
    private String website;
    private String phone;
    private String information;
}
