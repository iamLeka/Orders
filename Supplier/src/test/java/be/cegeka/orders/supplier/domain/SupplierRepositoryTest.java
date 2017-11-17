package be.cegeka.orders.supplier.domain;

import be.cegeka.orders.supplier.SupplierApplication;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = SupplierApplication.class)
@Transactional
public class SupplierRepositoryTest {
    private Order order1;
    private Order order2;
    private Order order3;

    @PersistenceContext
    private EntityManager entityManager;

    @Inject
    private SupplierRepository supplierRepository;

    @Before
    public void setUp() throws Exception {
        order1=new Order(1,"a",10);
        order2=new Order(1,"b",5);
        order3=new Order(2,"a",5);


    }

    @Test
    public void whenPlaceOrderIsCalledOrderShouldBeAddedToDB() throws Exception {
        supplierRepository.placeOrder(order1);
        Assertions.assertThat(supplierRepository.getAllOrders()).contains(order1);
    }

    @Test
    public void whenGetAllOrdersIsCalledShouldReturnAllOrdersForThatCustomer() throws Exception {
        entityManager.persist(order2);
        entityManager.persist(order3);
        Assertions.assertThat(supplierRepository.getAllOrders()).contains(order2,order3);
    }
}