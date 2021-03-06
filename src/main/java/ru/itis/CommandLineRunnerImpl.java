package ru.itis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.models.*;
import ru.itis.repositories.*;
import ru.itis.security.course.Course;
import ru.itis.security.role.Role;
import ru.itis.services.UserService;
import ru.itis.services.UserServiceImpl;

import java.util.Date;

@Configuration
public class CommandLineRunnerImpl implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private RecallRepository recallRepository;

    @Autowired
    private VacancyRepository vacancyRepository;

    @Autowired
    private RequestRepository requestRepository;

    @Autowired
    private RateRepository rateRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public void run(String... strings) throws Exception {


        String hashPassword = passwordEncoder.encode("ggwp");

        Company company1 = Company.builder()
                .name("Microsoft")
                .address("New York")
                .site("www.microsoft.com")
                .phoneNumber("87776662211")
                .information("Microsoft is good")
                .rating(5)
                .recallsCount(0)
                .checked(false)
                .build();

        Company company2 = Company.builder()
                .name("Amazon")
                .address("Los Angeles")
                .site("www.amazon.com")
                .phoneNumber("89991112345")
                .information("Amaon is good")
                .rating(4)
                .recallsCount(0)
                .checked(true)
                .build();

        companyRepository.save(company1);
        companyRepository.save(company2);


        User user1 = User.builder()
                .login("user1")
                .password(hashPassword)
                .name("user1")
                .course(Course.FIRST_COURSE)
                .phoneNumber("87770315689")
                .vkId("vk/qwerty")
                .telegramId("telegram/][poi")
                .email("user1@mail.ru")
                .facebookId("facebook/wfds")
                .addInformation("user1 is good")
                .company(company1)
                .role(Role.STUDENT)
                .build();


        User user2 = User.builder()
                .login("user2")
                .password(hashPassword)
                .name("user2")
                .course(Course.SECOND_COURSE)
                .phoneNumber("87056054973")
                .vkId("vk/jdfkjds")
                .telegramId("telegram/ewfnftg")
                .email("user2@mial.ru")
                .facebookId("facebook/jwefgre")
                .addInformation("user2 is good")
                .company(company1)
                .role(Role.STUDENT)
                .build();

        User user3 = User.builder()
                .login("user3")
                .password(hashPassword)
                .name("user3")
                .course(Course.THIRD_COURSE)
                .phoneNumber("89869074652")
                .vkId("vk/user3")
                .telegramId("telegram/user3")
                .email("user3@Mail.ru")
                .facebookId("facebook/user3")
                .addInformation("user3 is good")
                .company(company2)
                .role(Role.MODERATOR)
                .build();

        User user4 = User.builder()
                .login("user4")
                .password(hashPassword)
                .name("user4")
                .course(Course.SECOND_COURSE)
                .phoneNumber("87771236549")
                .vkId("vk/user4")
                .telegramId("telegram/user4")
                .email("user4@mial.ru")
                .facebookId("facebook/user4")
                .addInformation("user4 is good")
                .role(Role.STUDENT)
                .build();

        User userDecanat = User.builder()
                .login("decanat")
                .password(hashPassword)
                .name("decanat")
                .phoneNumber("87774562389")
                .vkId("vk/decanat")
                .telegramId("telegram/decanat")
                .email("decanat@mail.ru")
                .facebookId("facebook/decanat")
                .addInformation("decanat is good")
                .role(Role.DECANAT)
                .build();

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        userRepository.save(user4);
        userRepository.save(userDecanat);



        Vacancy vacancy1 = Vacancy.builder()
                .name("vacancy1")
                .salary(25000)
                .information("JAVA backend")
                .date(new Date())
                .checked(false)
                .company(company1)
                .user(user1)
                .build();

        Vacancy vacancy2 = Vacancy.builder()
                .name("vacancy1")
                .salary(30000)
                .information("Angular frontend")
                .date(new Date())
                .checked(false)
                .company(company1)
                .user(user2)
                .build();

        Vacancy vacancy3 = Vacancy.builder()
                .name("vacancy3")
                .salary(40000)
                .information("project manager")
                .date(new Date())
                .checked(true)
                .company(company2)
                .user(user1)
                .build();

        vacancyRepository.save(vacancy1);
        vacancyRepository.save(vacancy2);
        vacancyRepository.save(vacancy3);

        Recall recall1 = Recall.builder()
                .information("recall1")
                .rating(5)
                .date(new Date())
                .checked(false)
                .user(user1)
                .company(company1)
                .build();

        Recall recall2 = Recall.builder()
                .information("recall2")
                .rating(4)
                .date(new Date())
                .checked(false)
                .user(user2)
                .company(company1)
                .build();

        Recall recall3 = Recall.builder()
                .information("recall3")
                .rating(3)
                .date(new Date())
                .checked(true)
                .user(user1)
                .company(company2)
                .build();

        recallRepository.save(recall1);
        recallRepository.save(recall2);
        recallRepository.save(recall3);

        Request request1 = Request.builder()
                .type("Recall")
                .user(user1)
                .entityId(2L)
                .build();

        Request request2 = Request.builder()
                .type("Recall")
                .user(user1)
                .entityId(1L)
                .build();

        requestRepository.save(request1);
        requestRepository.save(request2);
        //System.out.println(Course.SECOND_COURSE.getValue());

        RateValue rateValue1 = RateValue.builder()
                .name("USD")
                .rate("70")
                .build();

        RateValue rateValue2 = RateValue.builder()
                .name("EUR")
                .rate("79")
                .build();

        RateValue rateValue3 = RateValue.builder()
                .name("KZT")
                .rate("6")
                .build();

        rateRepository.save(rateValue1);
        rateRepository.save(rateValue2);
        rateRepository.save(rateValue3);




        //List<User> users = userService.getUsersWithRoleStudent();
        //System.out.println(users.toString());

        //Company companyFromDb = companyRepository.findOne(1L);
        //System.out.println(companyFromDb);

        //System.out.println(companyFromDb.getUsers().toString());
    }
}
