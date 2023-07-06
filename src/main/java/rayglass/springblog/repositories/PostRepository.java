package rayglass.springblog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rayglass.springblog.models.Post;

public interface PostRepository extends JpaRepository <Post, Long>{

}