package edu.scardoni.appweb.repos;

import edu.scardoni.appweb.entities.CommentBlog;
import edu.scardoni.appweb.entities.PostBlog;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;






@Repository
public interface CommentsRepository extends JpaRepository<CommentBlog, Long> {

    List<CommentBlog> findAllByUnder(PostBlog post, Sort sort);

}
