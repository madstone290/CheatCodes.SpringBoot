package mad290.spring.tutorial.repositories;
import mad290.spring.tutorial.entities.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    List<Customer> findByLastName(String lastName);
}
