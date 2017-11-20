package be.cegeka.orders.order.application;

import be.cegeka.orders.order.domain.orders.OrderService;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import javax.inject.Inject;

import static org.junit.Assert.*;

public class OrderControllerTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Inject
    private OrderService orderService;

    @InjectMocks
    private OrderController orderController;

    @Test
    public void savingAnOrder_ShouldInvokeOrderService_AndShouldReturnAnOrder() throws Exception {

    }
}