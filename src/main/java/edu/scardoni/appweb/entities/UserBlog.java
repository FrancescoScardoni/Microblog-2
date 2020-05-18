package edu.scardoni.appweb.entities;

import java.util.Set;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;





@Entity
public class UserBlog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Basic
    @Column(name = "username", nullable = false, unique = true)
    public String username;

    @Basic
    public String email;

    @OneToMany(targetEntity = PostBlog.class)
    @Getter
    @Setter
    private Set<PostBlog> posts;

    @OneToMany(targetEntity = CommentBlog.class)
    @Getter
    @Setter
    private Set<CommentBlog> comments;

    public UserBlog() {
    }

    public UserBlog(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

   
}
