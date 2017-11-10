package be.cegeka.orders.order.domain.items;

import be.cegeka.orders.order.OrderApplication;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = OrderApplication.class)
@Transactional
public class ItemRepositoryTest {

    @Inject
    private ItemRepository itemRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void addingItemToItemTable_ShouldAddCorrectItem() throws Exception {
        Item expectedItem = new Item("Cara Pils","Probably The Best Beer In The World", BigDecimal.valueOf(0.23));
        itemRepository.addItem(expectedItem);

        Item acualItem = entityManager.find(Item.class,expectedItem.getId());
        Assertions.assertThat(acualItem).isEqualTo(expectedItem);
    }
}