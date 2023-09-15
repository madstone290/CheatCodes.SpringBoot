package mad290.spring.tutorial.services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import mad290.spring.tutorial.entities.AspNetUser;
import mad290.spring.tutorial.repositories.UserRepository;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
/*
    @Scope("request") is used to make sure that the UserService is created for each request.
    This is important because the EntityManager is not thread-safe.
    If we don't use @Scope("request"), then the EntityManager will be shared between requests.
    This will cause problems when multiple requests are made at the same time.
 */
@Scope("request")
public class UserService {
    /*
        The EntityManager is used for custom queries which is usually complex.
     */
    @PersistenceContext
    private EntityManager em;

    /*
        Spring jpa repository is used for basic CRUD operations and simple queries.
     */
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<AspNetUser> getAdminUser() {
        return em.createQuery("SELECT u FROM AspNetUser u WHERE u.isAdmin = true", AspNetUser.class)
                .getResultList()
                .stream()
                .findFirst();
    }

    public List<AspNetUser> findAll() {
        return StreamSupport.stream(userRepository.findAll().spliterator(), false)
                .toList();
    }

    public void save(AspNetUser user) {
        userRepository.save(user);
    }
}

