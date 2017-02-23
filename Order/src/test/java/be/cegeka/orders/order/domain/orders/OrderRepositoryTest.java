package be.cegeka.orders.order.domain.orders;

import be.cegeka.orders.order.OrderApplication;
import org.assertj.core.api.Assertions;
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

/**
 * Created by stijnli on 23/02/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = OrderApplication.class)
@Transactional
public class OrderRepositoryTest {
    @PersistenceContext
    private EntityManager entityManager;

    @Inject
    private  OrderRepository orderRepository;
    private Order order1,order2;

    @Before
    public void db_setup(){
        order1 = new Order();
        order2 = new Order();

        entityManager.persist(order1);
        entityManager.persist(order2);
    }
    @Test
    public void getAllShouldReturnAll(){
        Assertions.assertThat(orderRepository.getAll()).contains(order1,order2);
    }
}

