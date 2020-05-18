package edu.scardoni.appweb.entities;

import java.util.*;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;





@Entity
@Table(name = "comment")

public class CommentBlog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @Getter
    @Setter
    private PostBlog under;

    @ManyToOne
    public UserBlog author;

    @Temporal(TemporalType.TIMESTAMP)
    public Date date;

    @Lob
    @Column
    public String content;

}
