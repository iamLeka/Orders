package be.cegeka.orders.supplier.domain;

import javax.inject.Named;

@Named
public class OrderMapper {
    private OrderDTO orderDTO;

    public Order makeOrderFromOrderDTO(OrderDTO orderDTO){
        Order order=new Order(orderDTO.getCustomerId(),orderDTO.getItemName(),orderDTO.getAmount());
        return order;
    }
}
