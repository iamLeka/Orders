package be.cegeka.orders.order.domain.orders;

import be.cegeka.orders.order.OrderApplication;
import be.cegeka.orders.order.domain.customers.Customer;
import be.cegeka.orders.order.domain.customers.CustomerRepository;
import be.cegeka.orders.order.domain.items.Item;
import be.cegeka.orders.order.domain.items.ItemRepository;
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
import java.time.LocalDate;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = OrderApplication.class)
@Transactional
public class OrderRepositoryTest {
    @PersistenceContext
    private EntityManager entityManager;

    @Inject
    private CustomerRepository customerRepository;
    @Inject
    private OrderRepository orderRepository;
    private Order order1, order2;
    private Customer sanne;
    private Item item1, item2, item3;
    @Inject
    private ItemRepository itemRepository;

    @Before
    public void setUp(){
        sanne = new Customer("Sanne","Vermeiren");
        item1 = new Item("Wireless mouse","Logitech MX Master 2", 89.99);
        item2 = new Item("Lightning cable","Cable to connect iPhone 5 and later", 15.99);
        item3 = new Item("Headset", "Wireless headset Sony with noise cancelling", 149.99);
        order1 = new Order(sanne, LocalDate.now(), item1, item2, item3);
        order2 = new Order(new Customer("Wouter", "Bauweraerts"), LocalDate.now(), item1, item2, item3);

        entityManager.persist(order1);
        entityManager.persist(order2);
    }

    @Test
    public void tblOrders_getAllOrders_ContainsOrder1AndOrder2(){
        Assertions.assertThat(orderRepository.getAll()).containsExactly(order1, order2);
    }

    @Test
    public void testCascade_AddedOrderWithNewCustomer_CustomerGetsWrittenToDb(){
        Assertions.assertThat(customerRepository.getAll()).contains(sanne);
    }

    @Test
    public void tblOrders_GetAllOrders_OrderContainsOrderedItems(){
        Assertions.assertThat(orderRepository.getAll().get(0).getItems()).containsExactly(item1, item2, item3);
    }

    @Test
    public void tblItem_ContainsAllItemsThatWhereAddedInPrviousOrders(){
        Assertions.assertThat(itemRepository.getAll()).contains(item1, item2, item3);
    }

    @After
    public void clear(){
        entityManager.clear();
    }
}