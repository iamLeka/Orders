package be.cegeka.orders.order.domain.customers;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class CustomerService {

   @Inject
   private CustomerRepository customerRepository;

    public void addCustomer(String lastname, String firstName, String email, String address, String phone) {
        customerRepository.addCustomer(new Customer(lastname,firstName,email,address,phone));
    }
}
