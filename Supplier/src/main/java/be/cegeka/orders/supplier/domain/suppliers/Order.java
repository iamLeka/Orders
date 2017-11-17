package be.cegeka.orders.supplier.domain.suppliers;

import org.joda.time.DateTime;
import javax.persistence.*;

@Entity
@Table(name = "EXTERNAL_ORDERS")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "CUSTOMER_ID")
    private String customerId;
    @Column(name = "ORDERDATETIME")
    private DateTime orderDateTime;
    @Column(name = "ITEM")
    private String itemName;
    @Column(name = "AMOUNT")
    private int amount;

    public Order() {
    }

    public Order(String customerId, DateTime orderDateTime, String itemName, int amount) {
        this.customerId = customerId;
        this.orderDateTime = orderDateTime;
        this.itemName = itemName;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public DateTime getOrderDateTime() {
        return orderDateTime;
    }

    public String getItemName() {
        return itemName;
    }

    public int getAmount() {
        return amount;
    }
}
