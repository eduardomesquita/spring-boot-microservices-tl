package crawlertl.admin.services;

import crawlertl.admin.models.Customer;
import crawlertl.admin.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    public Flux<Customer> find(String lastname){
        return repository.findByLastnameLike(lastname);
    }

}
