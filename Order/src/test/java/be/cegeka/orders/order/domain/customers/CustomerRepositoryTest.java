package be.cegeka.orders.order.domain.customers;

import be.cegeka.orders.order.OrderApplication;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = OrderApplication.class)
@Transactional // reset situatie na elke test
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
        List<Customer> allPersistedCustomers = customerRepository.getAll();

        //THEN
        assertThat(allPersistedCustomers).contains(seppe, johan);
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

//    @After                            Overbodig(?) als @Transactional gebruikt wordt, tests blijven werken
//    public void cleanDatabase() {
//        entityManager.clear();
//    }
}
