package ru.itis.dto.company;
/*
 * @author Rustem Khairutdinov
 * @group 11-602
 */

import lombok.Builder;
import lombok.Data;

/*
 * Dto приходит с клиента при создании Компании
 */
@Data
@Builder
public class CompanyCreationDto {

    private String name;
    private String address;
    private String website;
    private String phone;
    private String information;
}
