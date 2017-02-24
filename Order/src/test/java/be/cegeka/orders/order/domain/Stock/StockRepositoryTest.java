package be.cegeka.orders.order.domain.Stock;

import be.cegeka.orders.order.OrderApplication;
import be.cegeka.orders.order.domain.items.Item;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = OrderApplication.class)
@Transactional
public class StockRepositoryTest {

    @PersistenceContext
    private EntityManager entityManager;

    @Inject
    private StockRepository stockRepository;
    private List<Stock> stockItems;
    private Item item;
    private Stock stock;


    @Before
    public void setUpDatabase(){
        stock = new Stock();
        //stockItems = new ArrayList<>();
       // item = new Item("smurf", "blue", 2.0);

        entityManager.persist(stock);
      //  entityManager.persist(item);
    }

    @Test
    public void getAllStock_returnsAllStock() throws Exception{
        assertThat(stockRepository.getAllStock()).contains(stock);
    }

}