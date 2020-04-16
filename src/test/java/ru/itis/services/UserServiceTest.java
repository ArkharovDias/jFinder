package ru.itis.services;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.models.User;
import ru.itis.repositories.UserRepository;
import ru.itis.security.course.Course;
import ru.itis.security.role.Role;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UserServiceTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Test
    public void getUserById_ValidId_ShouldReturnUser(){

        User userExpected = User.builder()
                .login("userForTest")
                .password("ggwp")
                .name("userForTest")
                .course(Course.FIRST_COURSE)
                .phoneNumber("8777787878")
                .vkId("vk/userForTest")
                .telegramId("telegram/yqghkejbqwf")
                .email("user1@mail.ru")
                .facebookId("facebook/qwdqwdqwd")
                .addInformation("userForTest is good")
                .role(Role.STUDENT)
                .build();

        userRepository.save(userExpected);

        User userActual = userService.getUserById(1L);

        Assert.assertEquals(userExpected, userActual);
    }

    @Test
    public void getUserById_InvalidId_ShouldReturnNull(){

        User userActual = userService.getUserById(564L);

        Assert.assertNull(userActual);
    }

}
