package be.cegeka.orders.order.domain.items;

import be.cegeka.orders.order.OrderApplication;
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
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = OrderApplication.class)
@Transactional
public class ItemRepositoryTest {

    @PersistenceContext
    private EntityManager entityManager;

    @Inject
    private ItemRepository itemRepository;
    private Item smurf, colaRola;

    @Before
    public void setupDatabase(){
        smurf = new Item("smurf", "blue", 2.0);
        colaRola = new Item("colaRola", "Tastes like cola", 3.0);

        entityManager.persist(smurf);
        entityManager.persist(colaRola);
    }

    @Test
    public void getAllItems_ShouldReturnAllItems() throws Exception{
        assertThat(itemRepository.getAllItems()).contains(smurf, colaRola);
    }
    @After
    public void cleanDatabase(){
        entityManager.clear();
    }
}