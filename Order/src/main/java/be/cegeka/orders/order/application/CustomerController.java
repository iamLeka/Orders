package be.cegeka.orders.order.application;


import be.cegeka.orders.order.domain.customer.Customer;
import be.cegeka.orders.order.domain.customer.CustomerService;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping(path = "/customer")
@Transactional
public class CustomerController {
    @Inject
    private CustomerService customerService;


    @PostMapping(path = "/addCustomer")
    public void addCustomer(
            @RequestParam(value = "lastName", required = true) String lastname,
            @RequestParam(value = "firstName", required = true) String firstName,
            @RequestParam(value = "email", required = true) String email,
            @RequestParam(value = "address", required = true) String address,
            @RequestParam(value = "phone", required = true) String phone
    ) {
        customerService.addCustomer(lastname, firstName, email, address, phone);
    }

    @GetMapping(path = "/getAll")
    public List<Customer> getAll(){
        return customerService.getAll();
    }
}
