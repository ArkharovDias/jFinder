package ru.itis.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.support.RepositoryEntityLinks;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import ru.itis.models.Recall;
import ru.itis.models.User;
import ru.itis.repositories.UserRepository;
import ru.itis.security.role.Role;
import ru.itis.services.UserService;

@Component
public class RecallRepresentationProcessor implements RepresentationModelProcessor<EntityModel<Recall>> {

    @Autowired
    private RepositoryEntityLinks links;

    @Autowired
    private UserService userService;

    @Override
    public EntityModel<Recall> process(EntityModel<Recall> model) {

        User user = userService.findUserByAuthentication(SecurityContextHolder.getContext().getAuthentication());

        Recall recall = model.getContent();

        if (user.getRole().equals(Role.MODERATOR)){
            model.add(links.linkToItemResource(Recall.class, recall.getId()).withRel("delete"));
            model.add(links.linkToItemResource(Recall.class, recall.getId()).withRel("update"));
        }

        return model;
    }
}
