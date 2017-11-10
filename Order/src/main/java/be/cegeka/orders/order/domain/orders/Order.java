package be.cegeka.orders.order.domain.orders;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "ORDERS")

public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ORDER_ID")
    private int id;
    @Column(name = "ORDER_DATE")
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
