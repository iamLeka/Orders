package be.cegeka.orders.order.application;

import be.cegeka.orders.order.domain.orders.Order;
import be.cegeka.orders.order.domain.orders.OrderService;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

@RestController
@RequestMapping(path = "/order")
@Transactional
public class OrderController {
    @Inject
    private OrderService orderService;

    @PostMapping(path = "/putInOrder", consumes = application / json)
    public void putInOrder( @RequestBody Order order) {
        orderService.putInOrder(order);
    }
}
