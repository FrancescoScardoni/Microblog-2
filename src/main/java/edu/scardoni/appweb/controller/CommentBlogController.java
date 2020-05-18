package edu.scardoni.appweb.controller;

import java.util.List;
import javax.ws.rs.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.http.MediaType;
import edu.scardoni.appweb.entities.CommentBlog;
import edu.scardoni.appweb.entities.PostBlog;
import edu.scardoni.appweb.repos.CommentsRepository;
import edu.scardoni.appweb.repos.PostRepository;





@RestController
@RequestMapping("/comments")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class CommentBlogController {

    @Autowired
    private CommentsRepository commentsRepo;

    @Autowired
    private PostRepository postsRepo;

    @RequestMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public List<CommentBlog> getAllUnder(@PathParam("post") Long id) {
        PostBlog post = postsRepo.findById(id).get();

        return commentsRepo.findAllByUnder(post, Sort.by("date"));
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CommentBlog> getAll() {
        return commentsRepo.findAll();
    }

    
}