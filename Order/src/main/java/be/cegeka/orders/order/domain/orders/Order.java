package be.cegeka.orders.order.domain.orders;

import be.cegeka.orders.order.domain.customers.Customer;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "ORDERS")

public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ORDER_ID")
    private int id;
    @Column(name = "ORDER_DATE")
    private Date orderDate;
    @OneToMany
    @JoinColumn(name = "ORDER_ID")
    private List<OrderItem> orderItem;


    public Order(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Order() {
    }

    public int getId() {
        return id;
    }

    public Date getOrder_date() {
        return orderDate;
    }



}
