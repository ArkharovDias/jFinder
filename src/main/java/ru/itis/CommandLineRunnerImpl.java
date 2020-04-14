package ru.itis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.models.*;
import ru.itis.repositories.*;

import java.util.Date;
import java.util.List;

@Configuration
public class CommandLineRunnerImpl implements CommandLineRunner {

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

    @Transactional
    @Override
    public void run(String... strings) throws Exception {

        /*Company company1 = Company.builder()
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
                .checked(false)
                .build();

        companyRepository.save(company1);
        companyRepository.save(company2);


        User user1 = User.builder()
                .login("user1")
                .password("ggwp")
                .name("user1")
                .course(1)
                .phoneNumber("87770315689")
                .vkId("vk/qwerty")
                .telegramId("telegram/][poi")
                .email("user1@mail.ru")
                .facebookId("facebook/wfds")
                .addInformation("user1 is good")
                .company(company1)
                .role("STUDENT")
                .build();

        User user2 = User.builder()
                .login("user2")
                .password("ggwp")
                .name("user2")
                .course(2)
                .phoneNumber("87056054973")
                .vkId("vk/jdfkjds")
                .telegramId("telegram/ewfnftg")
                .email("user2@mial.ru")
                .facebookId("facebook/jwefgre")
                .addInformation("user2 is good")
                .company(company1)
                .role("STUDENT")
                .build();

        User user3 = User.builder()
                .login("user3")
                .password("ggwp")
                .name("user3")
                .course(3)
                .phoneNumber("89869074652")
                .vkId("vk/user3")
                .telegramId("telegram/user3")
                .email("user3@Mail.ru")
                .facebookId("facebook/user3")
                .addInformation("user3 is good")
                .company(company2)
                .role("STUDENT")
                .build();

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);




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
                .checked(false)
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
                .checked(false)
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
        requestRepository.save(request2);*/

        Company companyFromDb = companyRepository.findOne(1L);
        System.out.println(companyFromDb);

        //System.out.println(companyFromDb.getUsers().toString());
    }
}
