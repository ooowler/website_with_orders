package project.example.artifact.repo;

import org.springframework.data.repository.CrudRepository;
import project.example.artifact.models.Post;
//вытягивает и изменяется значения

public interface PostRepository extends CrudRepository<Post, Long> {

}
