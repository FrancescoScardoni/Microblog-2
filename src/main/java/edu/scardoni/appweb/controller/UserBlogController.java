package edu.scardoni.appweb.controller;

import java.util.List;
import javax.ws.rs.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.http.MediaType;
import edu.scardoni.appweb.entities.UserBlog;
import edu.scardoni.appweb.repos.UserRepository;






@RestController
@RequestMapping("/users")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class UserBlogController {

    @Autowired
    private UserRepository userRepo;

    //getAllUser() prende tutti gli utenti
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserBlog> getAllUser() {
        return userRepo.findAll();
    }

    //metodi getbyId e findByUsername per trovare l'user con l'id
    @RequestMapping(method = RequestMethod.GET,value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserBlog getById(final String username) {
        return userRepo.findByUsername(username);
    }

    //creazione dell'utente
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response createUser(final UserBlog user) {

        if (userRepo.findByUsername(user.username) == null) {
            userRepo.saveAndFlush(user);
            return Response.status(Response.Status.CREATED).build();
        } else {
            return null;
        }

    }
}
