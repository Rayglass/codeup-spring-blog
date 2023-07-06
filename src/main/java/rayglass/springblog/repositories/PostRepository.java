package rayglass.springblog.repositories;
import rayglass.springblog.models.Post;

import org.springframework.data.jpa.repository.JpaRepository;
public interface PostRepository extends JpaRepository<Post, Long> {
}