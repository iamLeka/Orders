package be.cegeka.orders.order.domain.orders;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ORDERS")

public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    private int id;
    @Column(name = "ORDER_DATE")
    private Date orderDate;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "ORDER_ID", nullable = false)
    private List<OrderItem> orderItems;

    public Order(Date orderDate) {
        this.orderDate = orderDate;
        this.orderItems = new ArrayList<>();
    }

    public Order() {
    }

    public int getId() {
        return id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
    }
}
