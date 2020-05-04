package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import ru.itis.dto.company.CompanyDto;
import ru.itis.dto.item.CompanyItemDto;
import ru.itis.dto.profile.ProfileEditingDto;
import ru.itis.models.Company;
import ru.itis.models.User;
import ru.itis.repositories.UserRepository;
import ru.itis.security.role.Role;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserById(Long id){
        return userRepository.findOne(id);
    }

    @Override
    public User findUserByAuthentication(Authentication authentication) {
        return userRepository.getUserByLogin(authentication.getPrincipal().toString()).get();
    }


    @Override
    public void editUser(ProfileEditingDto profile, Authentication authentication) {

        User user = userRepository.getUserByLogin(authentication.getPrincipal().toString()).get();

        if (!user.getName().equals(profile.getName())){
            user.setName(profile.getName());
        }

        if (!user.getPhoneNumber().equals(profile.getPhone())){
            user.setPhoneNumber(profile.getPhone());
        }

        if(!user.getVkId().equals(profile.getVk())){
            user.setVkId(profile.getVk());
        }

        if (!user.getTelegramId().equals(profile.getTelegram())){
            user.setTelegramId(profile.getTelegram());
        }

        if (!user.getFacebookId().equals(profile.getFacebook())){
            user.setFacebookId(profile.getFacebook());
        }

        if (!user.getAddInformation().equals(profile.getAdditionalInformation())){
            user.setAddInformation(profile.getAdditionalInformation());
        }

        Company companyFromDb = user.getCompany();
        CompanyItemDto companyItemDto = profile.getCompany();

        if (!companyFromDb.getName().equals(companyItemDto.getName())){
            companyFromDb.setName(companyItemDto.getName());
        }

        userRepository.save(user);

    }

    public List<User> getUsersWithRoleStudent(){
        return userRepository.getUserWithRole(Role.STUDENT);
    }
}
