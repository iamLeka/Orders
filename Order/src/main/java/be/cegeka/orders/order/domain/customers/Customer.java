package be.cegeka.orders.order.domain.customers;

import be.cegeka.orders.order.domain.orders.Order;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CUSTOMERS")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CUSTOMER_ID")
    private int id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "LAST_NAME")
    private String lastName;

   /* @OneToMany(targetEntity = Order.class, cascade = CascadeType.ALL)
    @JoinTable(name = "ORDERS", joinColumns = {@JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "CUSTOMER_ID")},
    inverseJoinColumns = @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "CUSTOMER_ID"))
    private List<Order> orders;*/



    private Customer() {
//        orders = new ArrayList<>();
    }

    public Customer(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    /*public List<Order> getOrders() {
        return orders;
    }*/
}
