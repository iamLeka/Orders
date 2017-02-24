package be.cegeka.orders.order.domain.items;

import be.cegeka.orders.order.OrderApplication;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = OrderApplication.class)
@Transactional
public class ItemRepositoryTest {
@PersistenceContext
    private EntityManager entityManager;

@Inject
    private ItemRepository itemRepository;
    private OrderItem bic, postit;

    @Before
    public void setupDatabase() {
        bic = new OrderItem(new Item ("bic","Something to write whit doh",1.5),1);
        postit = new OrderItem(new Item ("postit", "Something sticky", 5.5),1);

        entityManager.persist(bic);
        entityManager.persist(postit);
    }

    @Test
    public void getAllShouldReturnAll() throws Exception{
        assertThat(itemRepository.getAll()).contains(bic, postit);
    }

    @After
    public void clean() {
        entityManager.clear();
    }
}