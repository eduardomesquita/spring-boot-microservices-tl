package crawlertl.admin.repositories;

import crawlertl.admin.models.Customer;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;


public interface CustomerRepository extends ReactiveCrudRepository<Customer, Long> {

    @Query("select id, firstname, lastname from customer c where c.lastname = $1")
    Flux<Customer> findByLastnameLike(String lastname);

}
