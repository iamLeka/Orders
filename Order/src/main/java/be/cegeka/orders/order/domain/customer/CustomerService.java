package be.cegeka.orders.order.domain.customer;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class CustomerService {

   @Inject
   private CustomerRepository customerRepository;

    public void addCustomer(String lastname, String firstName, String email, String address, String phone) {
        customerRepository.addCustomer(new Customer(lastname,firstName,email,address,phone));
    }

    public List<Customer> getAll() {
        return customerRepository.getAll();
    }
}
