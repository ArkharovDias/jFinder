package ru.itis.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.support.RepositoryEntityLinks;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import ru.itis.controllers.UserController;
import ru.itis.models.User;
import ru.itis.security.role.Role;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class UserRepresentationProcessor implements RepresentationModelProcessor<EntityModel<User>> {

    @Autowired
    private RepositoryEntityLinks links;

    @Override
    public EntityModel<User> process(EntityModel<User> model) {
        User user = model.getContent();

        if (user.getRole().equals(Role.MODERATOR)){
            model.add(linkTo(methodOn(UserController.class).getListUsers()).withRel("usersList"));
            model.add(links.linkToItemResource(User.class, user.getId()).withRel("delete"));
            model.add(links.linkToItemResource(User.class, user.getId()).withRel("update"));
        }
        return model;
    }
}
