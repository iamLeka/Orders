package be.cegeka.orders.order.domain.orders;

import be.cegeka.orders.order.domain.customer.Customer;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static be.cegeka.orders.order.domain.customer.CustomerTestBuilder.aCustomer;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class OrderServiceTest {
    private Customer customer;
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private OrderService orderService;

    @Mock
    private OrderRepository orderRepository;

//    @Test
//    public void putInOrder_shouldActivateOrderRepository() throws Exception {
//        Date date = new Date(20170823);
//        customer = aCustomer()
//                .withAddress("qskldfriltyr")
//                .withEmail("qeilehanzo")
//                .withFirstName("qsmldjkf")
//                .withLastName("qlzdkh")
//                .withPhone("6486784")
//                .withID(20)
//                .build();
//        List<OrderItem> list = new ArrayList<>();
//        Order order = new Order(date,list);
//        orderService.putInOrder(20,order);
//        verify(orderRepository).putInOrder(customer,order);
//    }
}