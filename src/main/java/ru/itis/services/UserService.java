package ru.itis.services;

import ru.itis.models.User;

import java.util.List;

public interface UserService {
    User getUserById(Long id);
    List<User> getUsersWithRoleStudent();
}
