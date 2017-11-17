package be.cegeka.orders.order.application;

import be.cegeka.orders.order.domain.items.Item;
import be.cegeka.orders.order.domain.items.ItemDto;
import be.cegeka.orders.order.domain.orders.Order;
import be.cegeka.orders.order.domain.orders.OrderItem;
import be.cegeka.orders.order.domain.orders.OrderService;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping(path = "/order")
@Transactional
public class OrderController {
    @Inject
    private OrderService orderService;

    @PostMapping(path = "/forcustomer/{customerid}", consumes = "application/json")
    public Order saveOrder(@RequestBody List<ItemDto> itemsToOrder,
                           @PathVariable(value = "customerid") int customerid) {
        return orderService.saveOrder(customerid,itemsToOrder);
    }
}
