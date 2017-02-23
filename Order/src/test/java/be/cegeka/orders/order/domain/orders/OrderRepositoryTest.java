package be.cegeka.orders.order.domain.orders;

import be.cegeka.orders.order.OrderApplication;
import be.cegeka.orders.order.domain.customers.Customer;
import be.cegeka.orders.order.domain.customers.CustomerRepository;
import org.apache.poi.sl.draw.geom.CosExpression;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import sun.util.calendar.BaseCalendar;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = OrderApplication.class)
@Transactional
public class OrderRepositoryTest {
    @PersistenceContext
    private EntityManager entityManager;

    @Inject
    private  OrderRepository orderRepository;
    private  Customer customer;
    private Order order1,order2;


    @Before
    public void db_setup(){
        customer = new Customer("Kevin","Smet");
        order1 = new Order(new Date(2016,10,25));
        order2 =  new Order(new Date());
        customer.addOrder(order1);
        customer.addOrder(order2);
        entityManager.persist(customer);


    }
    @Test
    public void getAllShouldReturnAll(){
        List<Order> orders = orderRepository.getAll();
        for (Order order: orders) {
            System.out.println(order);
        }
        Assertions.assertThat(orderRepository.getAll()).contains(order1,order2);
    }
    @After
    public void cleanDatabase(){
        entityManager.clear();
    }
}

