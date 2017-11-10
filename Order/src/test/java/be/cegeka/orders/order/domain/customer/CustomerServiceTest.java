package be.cegeka.orders.order.domain.customer;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

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
        Mockito.verify(customerRepository).addCustomer(new Customer ("verhaeghe", "gerard", "gerardke@gmail.com", "kerkstraat 21", "1245"));
    }
}