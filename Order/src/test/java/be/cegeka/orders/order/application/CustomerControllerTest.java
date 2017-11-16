package be.cegeka.orders.order.application;

import be.cegeka.orders.order.domain.customer.CustomerService;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class CustomerControllerTest {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private CustomerController customerController;

    @Mock
    private CustomerService customerService;


    @Test
    public void ifAddCustomerIsCalled_ShouldCallCustomerServiceAddCustomer() throws Exception {
        customerController.addCustomer("L", "H", "g", "E", "P");
        Mockito.verify(customerService).addCustomer("L", "H", "g", "E", "P");
    }

    @Test
    public void getAll_shouldCallGetAllInService() throws Exception {
        customerController.getAll();
        Mockito.verify(customerService).getAll();

    }
}