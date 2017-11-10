package be.cegeka.orders.order.domain.customer;

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
        assertThat(allPersistedCustomer).containsExactly(seppe, johan);
    }

    @Test
    public void addOneCustomer_shouldLetGetAllGetOnlyThatCustomer() throws Exception {
//        GIVEN
        Customer seppe = new Customer("Astarozna", "Bubba", "piemelboy69@Hotmale.USSR", "rode plein 2", "797204");

//        WHEN
        customerRepository.addCustomer(seppe);

//        THEN
        assertThat(customerRepository.getAll()).containsOnly(seppe);
    }

    @Test
    public void addTwoCustomers_shouldLetGetAllGetOnlyThoseCustomers() throws Exception {
//        GIVEN
        Customer seppe = new Customer("Astarozna", "Bubba", "piemelboy69@Hotmale.USSR", "rode plein 2", "797204");
        Customer johan = new Customer("Cruyff", "Beznik", "piemelboy70@Hotmale.USSR", "rode plein 2b", "797204");


//        WHEN
        customerRepository.addCustomer(seppe);
        customerRepository.addCustomer(johan);

//        THEN
        assertThat(customerRepository.getAll()).containsExactlyInAnyOrder(seppe,johan);
    }

}
