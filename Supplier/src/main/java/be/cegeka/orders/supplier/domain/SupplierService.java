package be.cegeka.orders.supplier.domain;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class SupplierService {
    @Inject
    private SupplierRepository supplierRepository;
    @Inject
    private OrderMapper orderMapper;
//    public void placeOrder(int customerId, String item, int amount) {
//        supplierRepository.placeOrder(new Order(customerId,item,amount));
//
//    }

    public Order placeOrder(OrderDTO orderDTO) {
        Order order=orderMapper.makeOrderFromOrderDTO(orderDTO);
        return supplierRepository.placeOrder(order);

    }

    public List<Order> getAllOrders() {
        return supplierRepository.getAllOrders();
    }
}
