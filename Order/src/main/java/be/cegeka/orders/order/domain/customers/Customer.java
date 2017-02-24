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
    @OneToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "orders",
            joinColumns = {@JoinColumn(name="CUSTOMER_ID")},
            inverseJoinColumns = {@JoinColumn(name="ORDER_ID")}
    )
    private List<Order> orders;

    private Customer() {
        orders = new ArrayList<>();
    }

    public Customer(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
        orders = new ArrayList<>();
    }
    public  Customer(String name, String lastName, List<Order> orders){
        this.name = name;
        this.lastName = lastName;
        this.orders = orders;
    }

    public int getId() {
        return id;
    }

    public void addOrder(Order order){
        orders.add(order);
    }

}
