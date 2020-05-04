package ru.itis.dto.item;
/*
 * @author Rustem Khairutdinov
 * @group 11-602
 */

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.models.Company;

/*
 * Dto представляет информацию о Компании, используется в других Dto
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompanyItemDto {

    private long id;
    private String name;

    public static CompanyItemDto from(Company company){
        return CompanyItemDto.builder()
                .id(company.getId())
                .name(company.getName())
                .build();
    }
}
