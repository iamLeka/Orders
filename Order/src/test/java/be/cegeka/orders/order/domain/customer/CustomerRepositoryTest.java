package be.cegeka.orders.order.domain.customer;

import be.cegeka.orders.order.OrderApplication;
import be.cegeka.orders.order.domain.items.Item;
import be.cegeka.orders.order.domain.orders.Order;
import be.cegeka.orders.order.domain.orders.OrderItem;
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
import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static be.cegeka.orders.order.domain.customer.CustomerTestBuilder.aCustomer;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = OrderApplication.class)
@Transactional
public class CustomerRepositoryTest {

    @PersistenceContext
    private EntityManager entityManager;

    @Inject
    private CustomerRepository customerRepository;

    @Before
    public void cleanDatabase() {
        entityManager.clear();
    }

    @Test
    public void getAllShouldReturnAll() throws Exception {
        //GIVEN
        Customer seppe = new Customer("Astarozna", "Bubba", "piemelboy69@Hotmale.USSR", "rode plein 2", "797204");
        Customer johan = new Customer("Cruyff", "Beznik", "piemelboy70@Hotmale.USSR", "rode plein 2b", "797204");
        entityManager.persist(seppe);
        entityManager.persist(johan);

        //WHEN
        List<Customer> allPersistedCustomer = customerRepository.getAll();

        //THEN
        assertThat(allPersistedCustomer).contains(seppe, johan);
    }

    @Test
    public void addOneCustomer_shouldcontainThatCustomer() throws Exception {
//        GIVEN
        Customer seppe = new Customer("Astarozna", "Bubba", "piemelboy69@Hotmale.USSR", "rode plein 2", "797204");

//        WHEN
        customerRepository.addCustomer(seppe);

//        THEN
        assertThat(customerRepository.getAll()).contains(seppe);
    }

    @Test
    public void addTwoCustomers_shouldContainThoseCustomers() throws Exception {
//        GIVEN
        Customer seppe = new Customer("Astarozna", "Bubba", "piemelboy69@Hotmale.USSR", "rode plein 2", "797204");
        Customer johan = new Customer("Cruyff", "Beznik", "piemelboy70@Hotmale.USSR", "rode plein 2b", "797204");


//        WHEN
        customerRepository.addCustomer(seppe);
        customerRepository.addCustomer(johan);

//        THEN
        assertThat(customerRepository.getAll()).contains(seppe,johan);
    }

    @Test
    public void getPreviousOrders_shouldCallOnRepository() throws Exception {
        Customer domien = aCustomer()
                .withLastName("Lemmens")
                .withFirstName("Domien")
                .withEmail("blabla@gmail.com")
                .withAddress("kerkstraat 25, moskou")
                .withPhone("neen")
                .build();
        entityManager.persist(domien);

        Item item1 =new Item("wodka","lekker",new BigDecimal(10.50));
        Item item2 =new Item("banaan","lekker",new BigDecimal(10.50));
        Item item3 =new Item("rum","lekker",new BigDecimal(10.50));

        OrderItem orderItem1 = new OrderItem(item1,5,LocalDate.now(),item1.getPrice());
        OrderItem orderItem2 = new OrderItem(item1,5,LocalDate.now(),item1.getPrice());
        OrderItem orderItem3 = new OrderItem(item1,5,LocalDate.now(),item1.getPrice());

        List<OrderItem> itemTestList = new ArrayList<>();
        itemTestList.add(orderItem1);
        itemTestList.add(orderItem2);
        itemTestList.add(orderItem3);

        Order order1 = new Order(Date.valueOf(LocalDate.now()));

        domien.addOrder(order1);

        customerRepository.getAllOrdersFromCustomer(domien.getId());

        assertThat(customerRepository.getAllOrdersFromCustomer(domien.getId())).contains(order1);

    }
}
