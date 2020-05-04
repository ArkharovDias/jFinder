package ru.itis.services;

import org.springframework.security.core.Authentication;
import ru.itis.dto.profile.ProfileEditingDto;
import ru.itis.models.User;

import java.util.List;

public interface UserService {
    User getUserById(Long id);
    User findUserByAuthentication(Authentication authentication);
    void editUser(ProfileEditingDto profile, Authentication authentication);
    List<User> getUsersWithRoleStudent();
}
