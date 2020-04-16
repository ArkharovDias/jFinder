package ru.itis.dto.profile;
/*
 * @author Rustem Khairutdinov
 * @group 11-602
 */

import lombok.Builder;
import lombok.Data;
import ru.itis.dto.item.CompanyItemDto;
import ru.itis.models.User;

import java.util.List;
import java.util.stream.Collectors;

/*
 * Dto отправляется на клиент при запросе Компании
 */
@Data
@Builder
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
        return ProfileDto.builder()
                .id(user.getId())
                .name(user.getName())
                .phone(user.getPhoneNumber())
                .vk(user.getVkId())
                .telegram(user.getTelegramId())
                .facebook(user.getFacebookId())
                .additionalInformation(user.getAddInformation())
                .company(CompanyItemDto.from(user.getCompany()))
                .build();
    }

    public static List<ProfileDto> from(List<User> users){
        return users.stream()
                .map(ProfileDto::from)
                .collect(Collectors.toList());
    }
}
