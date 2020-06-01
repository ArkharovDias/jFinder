package ru.itis.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.support.RepositoryEntityLinks;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import ru.itis.models.Company;
import ru.itis.models.Recall;
import ru.itis.models.User;
import ru.itis.models.Vacancy;
import ru.itis.security.role.Role;
import ru.itis.services.UserService;

@Component
public class VacancyRepresentationProcessor implements RepresentationModelProcessor<EntityModel<Vacancy>> {

    @Autowired
    private RepositoryEntityLinks links;

    @Autowired
    private UserService userService;

    @Override
    public EntityModel<Vacancy> process(EntityModel<Vacancy> model) {

        User user = userService.findUserByAuthentication(SecurityContextHolder.getContext().getAuthentication());

        Vacancy vacancy = model.getContent();

        if (user.getRole().equals(Role.MODERATOR)){
            model.add(links.linkToItemResource(Recall.class, vacancy.getId()).withRel("delete"));
            model.add(links.linkToItemResource(Recall.class, vacancy.getId()).withRel("update"));
        }

        return model;
    }
}
