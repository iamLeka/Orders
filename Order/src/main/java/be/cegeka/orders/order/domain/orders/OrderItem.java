package be.cegeka.orders.order.domain.orders;

import be.cegeka.orders.order.domain.items.Item;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name = "ITEMS_ON_ORDER")

public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="IOO_ID")
    private int id;
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "ITEM_ID")
    private Item item;
    @Column(name = "AMOUNT")
    private int amount;
    @Column(name = "SHIPPING_DATE")
    private Date shippingDate;
    @Column(name = "PRICE")
    private BigDecimal itemGroupPrice;

    public OrderItem() {
    }

    public OrderItem(Item item, int amount, LocalDate shippingDate, BigDecimal itemGroupPrice) {
        this.item = item;
        this.amount = amount;
        this.shippingDate = Date.valueOf(shippingDate);
        this.itemGroupPrice = itemGroupPrice;
    }

    public Item getItem() {
        return item;
    }

    public int getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    public Date getShippingDate() {
        return shippingDate;
    }

    public BigDecimal getItemGroupPrice() {
        return itemGroupPrice;
    }
}
