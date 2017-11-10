package be.cegeka.orders.order.domain.orders;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class OrderService {

    @Inject
    private OrderRepository orderRepository;

    public void putInOrder(Order order){




        orderRepository.putInOrder();
    }

}
