package be.cegeka.orders.order.domain.orders;

import be.cegeka.orders.order.OrderApplication;
import be.cegeka.orders.order.domain.customers.Customer;
import be.cegeka.orders.order.domain.customers.CustomerRepository;
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

    @Before
    public void setUp(){
        sanne = new Customer("Sanne","Vermeiren");
        order1 = new Order(sanne, LocalDate.now());
        order2 = new Order(new Customer("Wouter", "Bauweraerts"), LocalDate.now());

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

    @After
    public void clear(){
        entityManager.clear();
    }
}