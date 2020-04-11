package ru.itis.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String password;
    private String name;
    private int course;//TODO convert to ENUM
    private String phoneNumber;
    private String vkId;
    private String telegramId;
    private String email;
    private String facebookId;
    private String addInformation;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "company_id")
    private Company company;// спросить

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Recall> recalls;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Vacancy> vacancies;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Request> requests;

    private String role;//TODO convert to ENUM
}
