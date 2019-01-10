package crawlertl.admin.controllers;

import crawlertl.admin.models.Customer;
import crawlertl.admin.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService service;


    @RequestMapping("/")
    @ResponseBody
    public Flux<Customer> index(){
        return service.find("eduardo");
    }

}
