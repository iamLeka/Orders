package be.cegeka.orders.order.domain.orders;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class OrderRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Order> getAll(){
        return entityManager.createQuery("select o from custOrder o", Order.class).getResultList();
    }
}
