package ru.itis.repositories;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.models.User;
import ru.itis.security.course.Course;
import ru.itis.security.role.Role;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    /*
       MethodName_StateUnderTest_ExpectedBehavior
     */
    @Test
    public void getUserByLogin_ValidUser_ShouldFindUser(){

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

        User userActual = userRepository.getUserByLogin("userForTest");

        Assert.assertEquals(userExpected, userActual);
    }

    @Test
    public void getUserByLogin_InvalidLogin_ShouldNotFindUser(){

        User userValidLogin = User.builder()
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

        userRepository.save(userValidLogin);

        User userInvalidLogin = userRepository.getUserByLogin("ergregrg");

        Assert.assertNull(userInvalidLogin);
    }

    @Test
    public void getUsersWithRoleStudent_ValidUser_shouldFindUserWithRoleStudent(){

        User user1 = User.builder()
                .login("userForTest1")
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

        User user2 = User.builder()
                .login("userForTest2")
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

        User user3 = User.builder()
                .login("userForTest3")
                .password("ggwp")
                .name("userForTest")
                .course(Course.FIRST_COURSE)
                .phoneNumber("8777787878")
                .vkId("vk/userForTest")
                .telegramId("telegram/yqghkejbqwf")
                .email("user1@mail.ru")
                .facebookId("facebook/qwdqwdqwd")
                .addInformation("userForTest is good")
                .role(Role.MODERATOR)
                .build();

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

        List<User> userList = userRepository.getUserWithRole(Role.STUDENT);

        System.out.println(userList.toString());

        boolean bool = true;

        for (int i = 0; i < userList.size() && bool; i++) {
            bool = Role.STUDENT.equals(userList.get(i).getRole());
        }

        Assert.assertTrue(bool);
    }

    @Test
    public void getUsersWithRoleModerator_ValidUser_shouldFindUserWithRoleModerator(){

        User user1 = User.builder()
                .login("userForTest1")
                .password("ggwp")
                .name("userForTest")
                .course(Course.FIRST_COURSE)
                .phoneNumber("8777787878")
                .vkId("vk/userForTest")
                .telegramId("telegram/yqghkejbqwf")
                .email("user1@mail.ru")
                .facebookId("facebook/qwdqwdqwd")
                .addInformation("userForTest is good")
                .role(Role.MODERATOR)
                .build();

        User user2 = User.builder()
                .login("userForTest2")
                .password("ggwp")
                .name("userForTest")
                .course(Course.FIRST_COURSE)
                .phoneNumber("8777787878")
                .vkId("vk/userForTest")
                .telegramId("telegram/yqghkejbqwf")
                .email("user1@mail.ru")
                .facebookId("facebook/qwdqwdqwd")
                .addInformation("userForTest is good")
                .role(Role.MODERATOR)
                .build();

        User user3 = User.builder()
                .login("userForTest3")
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

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

        List<User> userList = userRepository.getUserWithRole(Role.MODERATOR);

        System.out.println(userList.toString());

        boolean bool = true;

        for (int i = 0; i < userList.size() && bool; i++) {
            bool = Role.MODERATOR.equals(userList.get(i).getRole());
        }

        Assert.assertTrue(bool);
    }
}
