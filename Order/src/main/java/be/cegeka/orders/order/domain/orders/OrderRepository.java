package be.cegeka.orders.order.domain.orders;

import be.cegeka.orders.order.domain.customer.Customer;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Named
public class OrderRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void putInOrder(Customer selectedCustomer, Order order){
        entityManager.persist(order);
        selectedCustomer.addOrder(order);
//        entityManager.persist(selectedCustomer);
    }

    public void addOrderItem(OrderItem i) {
        entityManager.persist(i);
    }
}
