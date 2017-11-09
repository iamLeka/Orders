package be.cegeka.orders.order.domain.orders;

import be.cegeka.orders.order.domain.customers.Customer;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name="orders")

public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="order_date")
    private Date order_date;
    @Column(name="customer_id")
    private Customer customer;
    @OneToMany
    @JoinColumn(name="order_id")
    private List<Order> orders;

    public Order(Date order_date, Customer customer) {
        this.order_date = order_date;
        this.customer = customer;
    }

    public Order() {
    }

    public int getId() {
        return id;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public Customer getCustomer() {
        return customer;
    }
}
