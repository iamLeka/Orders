package be.cegeka.orders.order.domain.Stock;

import be.cegeka.orders.order.OrderApplication;
import be.cegeka.orders.order.domain.customers.Customer;
import be.cegeka.orders.order.domain.items.Item;
import be.cegeka.orders.order.domain.stock.Stock;
import be.cegeka.orders.order.domain.stock.StockRepository;
import org.assertj.core.api.Assertions;
import org.junit.After;
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

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = OrderApplication.class)
@Transactional
public class StockRepositoryTest {

    @PersistenceContext
    private EntityManager entityManager;
    @Inject
    private StockRepository stockRepository;
    private Stock stock;
    private Item item;

    @Before
    public void setUp(){
        item = new Item("beer", "Six pack Jupiler", 6.99);
        stock = new Stock(item);

        entityManager.persist(stock);
    }

    @Test
    public void shouldReturnAll() throws Exception{
        Assertions.assertThat(stockRepository.getAll()).contains(stock);
    }

    @After
    public void clean(){
        entityManager.clear();
    }


}
