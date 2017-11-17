package be.cegeka.orders.order.domain.orders;

import be.cegeka.orders.order.domain.customer.Customer;
import be.cegeka.orders.order.domain.customer.CustomerRepository;
import be.cegeka.orders.order.domain.items.Item;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class OrderService {

    @Inject
    private OrderRepository orderRepository;
    @Inject
    private CustomerRepository customerRepository;

    public void putInOrder(int customerid, Order order){
        Customer selectedCustomer= customerRepository.getCustomerById(customerid);
        List<OrderItem> orderlist=order.getOrderItems();
        for (OrderItem i:orderlist) {
            orderRepository.addOrderItem(i);
        }
        orderRepository.putInOrder(selectedCustomer,order);
    }

}
