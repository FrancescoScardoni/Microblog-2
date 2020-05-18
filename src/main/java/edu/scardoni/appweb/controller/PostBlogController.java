package edu.scardoni.appweb.controller;

import edu.scardoni.appweb.entities.PostBlog;
import edu.scardoni.appweb.entities.UserBlog;
import edu.scardoni.appweb.repos.PostRepository;
import edu.scardoni.appweb.repos.UserRepository;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;





@RestController
@RequestMapping("/posts")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class PostBlogController {

    @Autowired
    private PostRepository postRepo;

    @Autowired
    private UserRepository userRepo;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PostBlog> getAllPoss() {
        List<PostBlog> post;
        post = postRepo.findAll();
        return post;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity createNew(@RequestBody PostBlog post) {

        UserBlog user = userRepo.findByUsername(post.getAuthor().getUsername());

        post.date = new Date();
        post.author = user;

        postRepo.saveAndFlush(post);

        return new ResponseEntity(HttpStatus.CREATED);

    }
}
