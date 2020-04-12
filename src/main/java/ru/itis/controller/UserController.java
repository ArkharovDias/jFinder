package ru.itis.controller;
/*
 * @author Rustem Khairutdinov
 * @group 11-602
 */

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import ru.itis.dto.profile.ProfileDto;
import ru.itis.dto.profile.ProfileEditingDto;

import java.util.List;

@RestController("/users")
public class UserController {

    /*
     * Метод возвращает список профилей с ролью студента
     */
    @GetMapping("/list")
    public List<ProfileDto> getUsers(){
        //TODO
        return null;
    }

    /*
     * Метод возвращает профиль студента(того, кто отправил запрос)
     */
    @GetMapping("/user}")
    public ProfileDto getUserMyself(Authentication authentication){
        //TODO
        return null;
    }

    /*
     * Метод возвращает профиль с ролью студента по {user_id}
     */
    @GetMapping("/user/{user_id}")
    public ProfileDto getUserById(@PathVariable("user_id") Long id){
        //TODO
        return null;
    }

    /*
     * Метод редактирует профиль студента(того, кто отправил запрос)
     */
    @PostMapping("/user")
    public void editUser(@RequestBody ProfileEditingDto profile, Authentication authentication){
        //TODO
    }
}
