package be.cegeka.orders.supplier.domain;

import org.joda.time.DateTime;
import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "EXTERNAL_ORDERS")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "CUSTOMERID")
    private int customerId;
    @Column(name = "ORDERDATETIME")
    private Timestamp orderDateTime;
    @Column(name = "ITEM")
    private String itemName;
    @Column(name = "AMOUNT")
    private int amount;

    public Order() {
    }

    public Order(int customerId,String itemName, int amount) {
        this.customerId = customerId;
        this.orderDateTime = Timestamp.valueOf(LocalDateTime.now());
        this.itemName = itemName;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public Timestamp getOrderDateTime() {
        return orderDateTime;
    }

    public String getItemName() {
        return itemName;
    }

    public int getAmount() {
        return amount;
    }
}
