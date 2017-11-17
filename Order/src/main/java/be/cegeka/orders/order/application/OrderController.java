package be.cegeka.orders.order.application;

import be.cegeka.orders.order.domain.orders.Order;
import be.cegeka.orders.order.domain.orders.OrderService;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.sql.Date;

@RestController
@RequestMapping(path = "/order")
@Transactional
public class OrderController {
    @Inject
    private OrderService orderService;

    @PostMapping(path = "/forcustomer/{customerid}", consumes = "application/json")
    public Order putInOrder(@RequestBody Order order, @PathVariable(value = "customerid") int customerid) {
        orderService.putInOrder(customerid,order);
        return order;
    }
}
