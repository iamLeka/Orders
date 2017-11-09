package be.cegeka.orders.order.domain.orders;

import be.cegeka.orders.order.domain.customers.Customer;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "orders")

public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "order_date")
    private Date orderDate;



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
