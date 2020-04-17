package ru.itis.models;

import lombok.*;
import ru.itis.security.course.Course;
import ru.itis.security.role.Role;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
@ToString(exclude = "company")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String password;
    private String name;

    @Enumerated(value = EnumType.ORDINAL)
    private Course course;

    private String phoneNumber;
    private String vkId;
    private String telegramId;
    private String email;
    private String facebookId;
    private String addInformation;
    private String refreshToken;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Recall> recalls;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Vacancy> vacancies;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Request> requests;
}
