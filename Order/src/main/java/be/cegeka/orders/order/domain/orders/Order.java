package be.cegeka.orders.order.domain.orders;

import be.cegeka.orders.order.domain.customers.Customer;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "ORDERS")
class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    private int orderId;

    @ManyToOne(targetEntity = Customer.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "CUSTOMER_ID",referencedColumnName = "CUSTOMER_ID")
    private Customer customer;

    @Column(name = "ORDER_DATE", columnDefinition = "Date")
    private LocalDate date;

    public Order() {
    }

    public Order(Customer customer, LocalDate date) {
        this.customer = customer;
        this.date = date;
    }

    public int getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public LocalDate getDate() {
        return date;
    }
}
