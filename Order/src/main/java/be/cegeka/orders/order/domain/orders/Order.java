package be.cegeka.orders.order.domain.orders;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "ORDERS")

public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    private int id;
    @Column(name = "ORDER_DATE")
    private LocalDate orderDate;
    @OneToMany
    @JoinColumn(name = "ORDER_ID", nullable = false)
    private List<OrderItem> orderItems;

    public Order(LocalDate orderDate, List<OrderItem> orderItems) {
        this.orderDate = orderDate;
        this.orderItems = orderItems;
    }

    public Order() {
    }

    public int getId() {
        return id;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }
}
