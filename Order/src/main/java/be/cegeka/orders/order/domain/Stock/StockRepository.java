package be.cegeka.orders.order.domain.Stock;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Named
public class StockRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Stock> getAllStock(){
        return entityManager.createQuery("select s from Stock s", Stock.class).getResultList();
    }





}
