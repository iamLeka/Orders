package be.cegeka.orders.order.domain.orders;

import be.cegeka.orders.order.domain.customers.Customer;
import be.cegeka.orders.order.domain.items.Item;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

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
    private LocalDate placedOrderDate;

    @ManyToMany(targetEntity = Item.class, cascade = CascadeType.ALL)
    @JoinTable(name = "ITEMS_ON_ORDER",
            joinColumns = {
                    @JoinColumn(name = "ORDER_ID", referencedColumnName = "ORDER_ID")},
            inverseJoinColumns = {@JoinColumn(name = "ITEM_ID", referencedColumnName = "ITEM_ID")
            })
    private Map<Item, LocalDate> items;

    public Order() {
        items = new HashMap<>();
    }

    public Order(Customer customer, LocalDate date) {
        this();
        this.customer = customer;
        this.placedOrderDate = date;
    }



    public Order(Customer customer, LocalDate date, Item... items) {
        this(customer, date);
        for (Item item: items) {
            this.items.put(item, ReturnShippingDate());

        }
    }
    // todo if stocklevel low shippingdate is + 1 week
    private LocalDate ReturnShippingDate() {
        return LocalDate.now().plusDays(1);
    }

    public int getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public LocalDate getplacedOrderDate() {
        return placedOrderDate;
    }

    public Map<Item, LocalDate> getItems() {
        return Collections.unmodifiableMap(items);
    }
}
