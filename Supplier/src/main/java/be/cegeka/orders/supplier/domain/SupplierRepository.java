package be.cegeka.orders.supplier.domain;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Named
public class SupplierRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public Order placeOrder(Order order){
        entityManager.persist(order);
        return order;

    }

    public List<Order> getAllOrders() {
        return entityManager
                .createQuery("select o from Order o",Order.class)
                .getResultList();
    }
}
