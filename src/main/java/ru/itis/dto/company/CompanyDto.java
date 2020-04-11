package ru.itis.dto.company;
/*
 * @author Rustem Khairutdinov
 * @group 11-602
 */

import lombok.Builder;
import lombok.Data;

/*
 * Dto отправляется на клиент при запросе Компаний(списка и одиночной)
 */
@Data
@Builder
public class CompanyDto {

    private long id;
    private String name;
    private String address;
    private String website;
    private String phone;
    private String information;
    private float rating;
    private int recallsCount;
}
