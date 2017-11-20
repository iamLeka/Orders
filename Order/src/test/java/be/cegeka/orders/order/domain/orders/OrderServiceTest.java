package be.cegeka.orders.order.domain.orders;

import be.cegeka.orders.order.domain.customer.Customer;
import be.cegeka.orders.order.domain.customer.CustomerRepository;
import be.cegeka.orders.order.domain.items.Item;
import be.cegeka.orders.order.domain.items.ItemDto;
import be.cegeka.orders.order.domain.items.ItemRepository;
import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static be.cegeka.orders.order.domain.customer.CustomerTestBuilder.aCustomer;
import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.refEq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class OrderServiceTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private OrderItemFactory orderItemFactory;

    @Mock
    private Customer customer;

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private ItemRepository itemRepository;

    @InjectMocks
    private OrderService orderService;

    @Test
    public void savingOrder_ShouldInvokeOrderRepositoryAndOrderItemFactory_AndReturnAnOrder() throws Exception {
        Order order = new Order(Date.valueOf(LocalDate.of(2017,11,20)));
        ItemDto itemDto1 = new ItemDto(1,5);
        ItemDto itemDto2 = new ItemDto(2,5);

        List<ItemDto> itemDtoList = Arrays.asList(itemDto1, itemDto2);

        order.addOrderItem(orderItemFactory.makeOrderItemFromDto(itemDto1));
        order.addOrderItem(orderItemFactory.makeOrderItemFromDto(itemDto2));

        when(customerRepository.getCustomerById(1)).thenReturn(customer);

        orderService.saveOrder(1,itemDtoList);

        verify(customer).addOrder(refEq(order));
    }
}