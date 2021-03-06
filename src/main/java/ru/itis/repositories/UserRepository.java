package ru.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.itis.models.User;
import ru.itis.security.role.Role;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("from User user where user.role = ?1")
    List<User> getUserWithRole(Role role);

    //@Query("from User user where user.login = ?1")
    Optional<User> getUserByLogin(String login);
}
