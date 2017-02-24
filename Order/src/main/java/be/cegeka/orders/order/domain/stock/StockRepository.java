package be.cegeka.orders.order.domain.stock;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class StockRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Stock> getAll(){
        return entityManager.createQuery("select s from Stock s", Stock.class).getResultList();
    }
}
