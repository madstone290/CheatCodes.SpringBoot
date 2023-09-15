package mad290.spring.tutorial.repositories;

import mad290.spring.tutorial.entities.AspNetUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<AspNetUser, Integer> { }

