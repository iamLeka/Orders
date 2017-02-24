package be.cegeka.orders.order.domain.items;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "ORDERITEMS")
public class OrderItem implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDERITEM_ID")
    private int id;

    public int getId() {
        return id;
    }

    @OneToOne(targetEntity = Item.class,fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "ITEM_ID", referencedColumnName = "ITEM_ID")
    private Item item;

    @Column(name = "QUANTITY")
    private int quantity;

    @Column(name = "DELIVERY_DATE")
    private LocalDate deliveryDate;

    public OrderItem() {
    }

    public OrderItem(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
}
