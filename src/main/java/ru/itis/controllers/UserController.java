package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import ru.itis.dto.profile.ProfileDto;
import ru.itis.dto.profile.ProfileEditingDto;
import ru.itis.models.User;
import ru.itis.services.UserService;


import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    /*
     * Метод возвращает список профилей с ролью студента
     */
    @GetMapping("/list")
    public List<ProfileDto> getUsers(){

        List<User> userList = userService.getUsersWithRoleStudent();

        List<ProfileDto> resultList = ProfileDto.from(userList);

        return resultList;
    }

    /*
     * Метод возвращает профиль студента(того, кто отправил запрос)
     */
    @GetMapping("/user")
    public ProfileDto getUserMyself(Authentication authentication){
        //TODO
        return null;
    }

    /*
     * Метод возвращает профиль с ролью студента по {user_id}
     */
    @GetMapping("/user/{user_id}")
    public ProfileDto getUserById(@PathVariable("user_id") Long id){

        User user = userService.getUserById(id);

        ProfileDto resultUser = ProfileDto.from(user);

        return resultUser;
    }

    /*
     * Метод редактирует профиль студента(того, кто отправил запрос)
     */
    @PostMapping("/user")
    public void editUser(@RequestBody ProfileEditingDto profile, Authentication authentication){
        //TODO
    }

}
