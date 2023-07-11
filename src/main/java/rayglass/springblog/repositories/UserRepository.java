package rayglass.springblog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rayglass.springblog.models.Post;
import rayglass.springblog.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

