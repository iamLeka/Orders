package be.cegeka.orders.order.domain.items;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Named
public class ItemRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Item> getAll() {
        return entityManager.createQuery("select i from Item i" , Item.class).getResultList();
    }
}
