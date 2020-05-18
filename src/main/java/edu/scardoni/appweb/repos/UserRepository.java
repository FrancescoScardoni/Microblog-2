package edu.scardoni.appweb.repos;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import edu.scardoni.appweb.entities.UserBlog;

@Repository
public interface UserRepository extends JpaRepository<UserBlog, Long> {

    UserBlog findByUsername(String username);

    List<UserBlog> findByEmail(String email);
}
