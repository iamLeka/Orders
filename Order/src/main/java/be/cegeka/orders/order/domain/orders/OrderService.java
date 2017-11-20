package be.cegeka.orders.order.domain.orders;

import be.cegeka.orders.order.domain.customer.Customer;
import be.cegeka.orders.order.domain.customer.CustomerRepository;
import be.cegeka.orders.order.domain.items.Item;
import be.cegeka.orders.order.domain.items.ItemDto;
import be.cegeka.orders.order.domain.items.ItemRepository;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Named
public class OrderService {

    @Inject
    private CustomerRepository customerRepository;

    @Inject
    private ItemRepository itemRepository;

    @Inject
    private OrderItemFactory orderItemFactory;

    public Order saveOrder(int customerid, List<ItemDto> itemsToOrder){
        Customer customer = customerRepository.getCustomerById(customerid);

        Order order = new Order(Date.valueOf(LocalDate.now()));

        for (ItemDto itemDto : itemsToOrder) {
            order.addOrderItem(orderItemFactory.makeOrderItemFromDto(itemDto));
        }

        customer.addOrder(order);

        return order;
    }
}
