package be.cegeka.orders.order.application;

import be.cegeka.orders.order.domain.items.ItemDto;
import be.cegeka.orders.order.domain.orders.Order;
import be.cegeka.orders.order.domain.orders.OrderService;
import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import javax.inject.Inject;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class OrderControllerTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    private OrderService orderService;

    @InjectMocks
    private OrderController orderController;

    @Test
    public void savingAnOrder_ShouldInvokeOrderService_AndShouldReturnAnOrder() throws Exception {
        ItemDto itemDto = new ItemDto(1,5);
        List<ItemDto> itemDtoList = Arrays.asList(itemDto);
        Order order = new Order(Date.valueOf(LocalDate.now()));

        when(orderService.saveOrder(1,itemDtoList)).thenReturn(order);

        Assertions.assertThat(orderController.saveOrder(itemDtoList,1)).isEqualTo(order);
    }
}