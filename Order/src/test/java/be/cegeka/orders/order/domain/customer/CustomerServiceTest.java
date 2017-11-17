package be.cegeka.orders.order.domain.customer;

import be.cegeka.orders.order.domain.orders.Order;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static be.cegeka.orders.order.domain.customer.CustomerTestBuilder.aCustomer;
import static org.mockito.ArgumentMatchers.doubleThat;
import static org.mockito.Mockito.verify;

public class CustomerServiceTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private CustomerService customerService;

    @Mock
    private CustomerRepository customerRepository;

    @Test
    public void addCustomerIsCalled_shouldCallCorrespondingMethodInRepository() throws Exception {
        customerService.addCustomer("verhaeghe", "gerard", "gerardke@gmail.com", "kerkstraat 21", "1245");
        verify(customerRepository).addCustomer(new Customer ("verhaeghe", "gerard", "gerardke@gmail.com", "kerkstraat 21", "1245"));
    }

    @Test
    public void getAll_shouldGetAllInCustomerRepository() throws Exception {
        customerService.getAll();
        verify(customerRepository).getAll();
    }

    @Test
    public void getPreviousOrdersByCustomerId_shouldGetAllPreviousOrdersFromRepository() throws Exception {

        Customer domien = aCustomer()
                .withID(30)
                .withLastName("Lemmens")
                .withFirstName("Domien")
                .withEmail("piemeljongennegenenzestigenhalf@hetejongen.xxx")
                .withAddress("kerkstraat 25, moskou")
                .withPhone("neen")
                .build();
        Order order1 = new Order();
        Order order2 = new Order();


        domien.addOrder(order1);
        domien.addOrder(order2);

        customerService.getAllOrdersFromCustomer(30);
        verify(customerRepository).getAllOrdersFromCustomer(30);
    }
}