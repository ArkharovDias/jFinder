package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    public List<User> getUsersWithRoleStudent(){
        return userRepository.getUserWithRole(Role.STUDENT);
    }
}
