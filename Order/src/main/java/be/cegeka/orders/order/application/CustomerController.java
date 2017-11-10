package be.cegeka.orders.order.application;


import be.cegeka.orders.order.domain.customers.CustomerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.transaction.Transactional;

@RestController
@RequestMapping(path = "/customers")
@Transactional
public class CustomerController {
    @Inject
    private CustomerService customerservice;


    @PostMapping(path = "/addCustomer")
    public void addCustomer(
            @RequestParam(value = "lastName", required = true) String lastname,
            @RequestParam(value = "firstName", required = true) String firstName,
            @RequestParam(value = "email", required = true) String email,
            @RequestParam(value = "address", required = true) String address,
            @RequestParam(value = "phone", required = true) String phone
    ) {
        customerservice.addCustomer(lastname, firstName, email, address, phone);
    }
}
