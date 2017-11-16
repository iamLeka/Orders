package be.cegeka.orders.order.domain.customer;

import be.cegeka.orders.order.OrderApplication;
import be.cegeka.orders.order.domain.orders.Order;
import be.cegeka.orders.order.domain.orders.OrderItem;
import jersey.repackaged.com.google.common.collect.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import java.sql.Date;
import java.util.List;

import static jersey.repackaged.com.google.common.collect.Lists.newArrayList;
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
    public void addCustomer_shouldLetGetAllGetOnlyThatCustomer() throws Exception {
//        GIVEN
        Customer seppe = new Customer("Astarozna", "Bubba", "piemelboy69@Hotmale.USSR", "rode plein 2", "797204");

//        WHEN
        customerRepository.addCustomer(seppe);

//        THEN
        assertThat(customerRepository.getAll()).containsOnly(seppe);
    }

    @Test
    public void name() throws Exception {
        Customer seppe = new Customer("Astarozna", "Bubba", "piemelboy69@Hotmale.USSR", "rode plein 2", "797204");
        entityManager.persist(seppe);

        seppe.addOrder(new Order(new Date(1,1,2018), newArrayList()));
        entityManager.persist(seppe);
    }

    //    @After                            Overbodig(?) als @Transactional gebruikt wordt, tests blijven werken
//    public void cleanDatabase() {
//        entityManager.clear();
//    }
}
