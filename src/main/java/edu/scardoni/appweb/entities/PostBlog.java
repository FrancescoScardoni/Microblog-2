package edu.scardoni.appweb.entities;

import java.util.Date;
import javax.persistence.*;





@Entity
public class PostBlog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Temporal(TemporalType.TIMESTAMP)
    public Date date;

    @Basic //varchar(255)
    public String title;

    @Lob //varchar(Max_Lenght) 
    public String content;

    @ManyToOne
    public UserBlog author;

    public PostBlog() {
    }

    public PostBlog(Date date, String title, String content, UserBlog author) {
        this.date = date;
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public long getId() {
        return this.id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UserBlog getAuthor() {
        return author;
    }

    public void setAuthor(UserBlog author) {
        this.author = author;
    }

    
    
}
