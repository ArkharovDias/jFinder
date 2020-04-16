package ru.itis.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "companies")
@ToString
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
    private String site;
    private String phoneNumber;
    private String information;
    private float rating;
    private int recallsCount;
    private boolean checked;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
    private List<User> users;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
    private List<Recall> recalls;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
    private List<Vacancy> vacancies;
}
