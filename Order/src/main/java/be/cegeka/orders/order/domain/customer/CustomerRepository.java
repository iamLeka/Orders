package be.cegeka.orders.order.domain.customer;

import be.cegeka.orders.order.domain.orders.Order;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Named
public class CustomerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Customer> getAll(){
        return entityManager.createQuery("select c from Customer c" , Customer.class).getResultList();
    }

    public void addCustomer(Customer customer) {
        entityManager.persist(customer);
    }

    public Customer getCustomerById(int customerid) {
        return entityManager.find(Customer.class,customerid);
    }

    public List<Order> getAllOrdersFromCustomer(int customerId) {
      return  getCustomerById(customerId).getOrderList();
    }
}
