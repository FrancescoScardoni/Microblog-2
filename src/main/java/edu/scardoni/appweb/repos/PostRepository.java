package edu.scardoni.appweb.repos;

import java.util.List;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import edu.scardoni.appweb.entities.PostBlog;
import edu.scardoni.appweb.entities.UserBlog;

@Repository
public interface PostRepository extends JpaRepository<PostBlog, Long> {

    List<PostBlog> findByAuthor(UserBlog author);

    List<PostBlog> findByTitle(String title);

}
