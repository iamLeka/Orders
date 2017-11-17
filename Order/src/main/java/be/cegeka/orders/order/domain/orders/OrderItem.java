package be.cegeka.orders.order.domain.orders;

import be.cegeka.orders.order.domain.items.Item;

import javax.persistence.*;

@Entity
@Table(name = "ITEMS_ON_ORDER")

public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="IOO_ID")
    private int id;
    @ManyToOne
    @JoinColumn(name = "ITEM_ID")
    private Item item;

    public Item getItem() {
        return item;
    }

    public int getId() {
        return id;
    }
}
