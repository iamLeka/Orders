package be.cegeka.orders.order.domain.items;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Named
public class ItemRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void addItem(Item item) {
        entityManager.persist(item);
    }
}
