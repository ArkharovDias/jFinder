package ru.itis.dto.profile;
/*
 * @author Rustem Khairutdinov
 * @group 11-602
 */

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.dto.item.CompanyItemDto;
import ru.itis.models.User;

import java.util.List;
import java.util.stream.Collectors;

/*
 * Dto отправляется на клиент при запросе Компании
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProfileDto {

    private long id;
    private String name;
    private String phone;
    private String vk;
    private String telegram;
    private String facebook;
    private String additionalInformation;
    private CompanyItemDto company;

    public static ProfileDto from(User user){

        ProfileDto profileDto = ProfileDto.builder()
                .id(user.getId())
                .name(user.getName())
                .phone(user.getPhoneNumber())
                .vk(user.getVkId())
                .telegram(user.getTelegramId())
                .facebook(user.getFacebookId())
                .additionalInformation(user.getAddInformation())
                .build();

        if (user.getCompany() != null){
            profileDto.setCompany(CompanyItemDto.from(user.getCompany()));
        }

        return profileDto;
    }

    public static List<ProfileDto> from(List<User> users){
        return users.stream()
                .map(ProfileDto::from)
                .collect(Collectors.toList());
    }
}
