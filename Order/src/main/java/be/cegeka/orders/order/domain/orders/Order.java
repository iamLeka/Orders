package be.cegeka.orders.order.domain.orders;

import be.cegeka.orders.order.domain.customers.Customer;
import be.cegeka.orders.order.domain.items.Item;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "ORDERS")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    private int orderId;

    @ManyToOne(targetEntity = Customer.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "CUSTOMER_ID")
    private Customer customer;

    @Column(name = "ORDER_DATE", columnDefinition = "Date")
    private LocalDate date;

    @ManyToMany(targetEntity = Item.class, cascade = CascadeType.ALL)
    @JoinTable(name = "ITEMS_ON_ORDER",
            joinColumns = {
                    @JoinColumn(name = "ORDER_ID", referencedColumnName = "ORDER_ID")},
            inverseJoinColumns = {@JoinColumn(name = "ITEM_ID", referencedColumnName = "ITEM_ID")
            })
    private List<Item> items;

    public Order() {
        items = new ArrayList<>();
    }

    public Order(Customer customer, LocalDate date) {
        this();
        this.customer = customer;
        this.date = date;
    }

    public Order(Customer customer, LocalDate date, Item... items) {
        this(customer, date);
        this.items = Arrays.asList(items);
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

    public List<Item> getItems() {
        return Collections.unmodifiableList(items);
    }
}
